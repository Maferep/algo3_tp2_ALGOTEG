package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import javax.swing.text.StyledEditorKit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.ArrayList;

public class Jugador implements IJugador {
	public static final String CANTIDAD_PAISES = "cantidadPaises";
	public static final String PAISES = "paises";
	IObjetivo objetivo;

	private String color;
	private List<IPais> paises;
	private List<Tarjeta> tarjetas;
	private int ejercitosPorColocar;
	public Mazo mazo;
	int numeroDeCanje = 0;

	static int minimoPaises = 30;

	public Jugador(String colorDelJugador) {
		color = colorDelJugador;
		paises = new ArrayList<IPais>();
		tarjetas = new ArrayList<Tarjeta>();
		ejercitosPorColocar = 0;
	}

	//Tienes una lista de listeners, o sea, a quienes les interesa el evento
	private List<PropertyChangeListener> suscriptores = new ArrayList<PropertyChangeListener>();

	

	public String obtenerColor() {
		return color;
	}

	public List<IPais> obtenerPaises() {
		return this.paises;
	}

	public int cantidadEjercitosPorColocar() {
		return ejercitosPorColocar;
	}

	@Override
	public int cantidadPaises() {
		return paises.size();
	}

	@Override
	public void inicializarEjercitos(int cantidad) throws EjercitosException {
		if(cantidad <= 0)
			throw new EjercitosException(null);
		ejercitosPorColocar += cantidad;
	}

	/*
	Resetea ejércitos por colocar y los redefine segun la cantidad de paises.
	*/
	@Override
	public void agregarNuevosEjercitos(int cantidad) throws EjercitosException {
		this.ejercitosPorColocar = 0;
		if(cantidad <= 0) throw new EjercitosException("cantidadInvalida");
		if(this.paises.size() < 6) {
			this.ejercitosPorColocar += 3;
		}
		else {
			this.ejercitosPorColocar += cantidad;
		}
	}

	//agrega un pais con un ejército nuevo. 
	//define el conquistador del pais.
	//No afecta la cantidad de ejércitos por colocar del jugador.
	public void inicializarPais(IPais pais) {
		pais.definirConquistador(this);
		pais.agregarEjercitos(1);
	}

	public void asignarPais(IPais pais) {
		int paisesQueTenia = paises.size();
		List<IPais> listaAnterior = new ArrayList<IPais>();
		listaAnterior.addAll(paises);

		paises.add(pais);

		notifyListeners(this, CANTIDAD_PAISES, paisesQueTenia, paises.size());
		notifyListeners(this, PAISES, listaAnterior, paises);
	}

	public void quitarPais(IPais pais) {
		int paisesQueTenia = paises.size();
		List<IPais> listaAnterior = new ArrayList<IPais>();
		listaAnterior.addAll(paises);

		paises.remove(pais);
		
		notifyListeners(this, CANTIDAD_PAISES, paisesQueTenia, paises.size());
		notifyListeners(this, PAISES, listaAnterior, paises);
	}

	public void agregarEjercitosAPais(IPais pais, int cantEjercitos) throws FichasInsuficientesError,
			PaisNoExistenteError, EjercitosException {
		verificarPais(pais);
		verificarCantidadDeEjercitos(cantEjercitos);
		pais.agregarEjercitos(cantEjercitos);
		quitarEjercitos(cantEjercitos);
	}

	private void verificarPais(IPais pais) throws PaisNoExistenteError {
		for(int i = 0 ; i < paises.size() ; i++) {
			if( paises.get(i).obtenerNombre().equals(pais.obtenerNombre())) {
				return;
			}
		}
		throw new PaisNoExistenteError("El jugador no es conquistador del pais " + pais.obtenerNombre());
	}

	private void verificarCantidadDeEjercitos(int cantEjercitos) throws FichasInsuficientesError{
		if(cantEjercitos > this.cantidadEjercitosPorColocar()) {
			throw new FichasInsuficientesError("No tienes esa cantidad de fichas para colocar en el pais");
		}
	}

	//Sistema de canjes

	public void asignarCanje(Mazo mazoNuevo) {
		mazo = mazoNuevo;
	}

	public void agregarTarjetaAleatoria(Tarjeta tarjeta) {
		tarjetas.add(tarjeta);
	}

	public void activarTarjeta(Tarjeta tarjeta, ICanje tipoDeCanje) throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
		this.realizarVerificaciones(tarjeta);
		tarjeta.activarTarjeta(this, tipoDeCanje);
		this.mazo.insertarAlFondoDelMazo(tarjeta);
		this.tarjetas.remove(tarjeta);
		this.actualizarNumeroDeCanje();
	}

	public void actualizarNumeroDeCanje() {
		numeroDeCanje++;
	}

	public int obtenerNumeroDeCanje() { return numeroDeCanje; }

	// verificaciones para los canjes

	public void realizarVerificaciones(Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError {
		this.verificarQueExistaTarjeta(tarjeta);
		this.verificarQueExistaPais(tarjeta.obtenerPais());
	}

	public boolean verificarQueExistaTarjeta(Tarjeta tarjeta) throws NoExisteTarjetaException {
		for(int i = 0 ; i < tarjetas.size() ; i++) {
			if(tarjetas.get(i).obtenerPais() == tarjeta.obtenerPais()) {
				return true;
			}
		}
		throw new NoExisteTarjetaException("No tienes la tarjeta que buscas activar");
	}

	public boolean verificarQueExistaPais(IPais pais) throws PaisNoExistenteError {
		for(int i = 0 ; i < this.cantidadPaises() ; i++) {
			if(this.obtenerPaises().get(i).obtenerNombre().equals(pais.obtenerNombre())) {
				return true;
			}
		}
		throw new PaisNoExistenteError("No tienes este pais para agregar fichas");
	}

	@Override
	public int cantidadTarjetas() {
		return tarjetas.size();
	}

	@Override
	public void quitarEjercitos(int cantidadAQuitar) throws EjercitosException {
		ejercitosPorColocar -= cantidadAQuitar;
		if(ejercitosPorColocar < 0) throw new EjercitosException("quita demasiados ejercitos");
	}

	//para objetivos
	public void asignarObjetivo(IObjetivo objetivoAsignado) {
		objetivoAsignado.inicializar(this);
		objetivo = objetivoAsignado;
	}

	//metodo para notificar a los listeners de todo evento
	private void notifyListeners(Object source, String property, Object oldValue, Object newValue) {
		for (PropertyChangeListener suscriptor : suscriptores) {
			PropertyChangeEvent event = new PropertyChangeEvent(this, property, oldValue, newValue);
			suscriptor.propertyChange(event);
		}
	}

	public void agregarObjetivoSuscriptor(IObjetivo objetivo) {
		this.addChangeListener(objetivo);
	}

	private void addChangeListener(PropertyChangeListener suscriptor) {
		suscriptores.add(suscriptor);
	}

	

}
