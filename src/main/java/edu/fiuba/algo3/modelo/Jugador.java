package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.List;
import java.util.ArrayList;

public class Jugador implements IJugador {

	String color;
	//TODO: smell de atributo publico
	public List<IPais> paises;
	List<Tarjeta> tarjetas;
	int ejercitosPorColocar;
	IObjetivo objetivo;

	static int minimoPaises = 30;

	public Jugador(String colorDelJugador) {
		color = colorDelJugador;
		paises = new ArrayList<IPais>();
		tarjetas = new ArrayList<Tarjeta>();
		ejercitosPorColocar = 0;
	}

	public String obtenerColor() {
		return color;
	}

	public List<IPais> obtenerPaises() {
		return this.paises;
	}

	public int cantidadEjercitos() {
		return ejercitosPorColocar;
	}

	@Override
	public void inicializarEjercitos(int cantidad) throws EjercitosException {
		if(cantidad <= 0)
			throw new EjercitosException(null);
		ejercitosPorColocar += cantidad;
	}

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

	public void asignarPais(IPais pais) {
		paises.add(pais);
	}

	public void quitarPais(IPais pais) {
		paises.remove(pais);
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
		if(cantEjercitos > this.cantidadEjercitos()) {
			throw new FichasInsuficientesError("No tienes esa cantidad de fichas para colocar en el pais");
		}
	}

	public void agregarTarjetaAleatoria(Tarjeta tarjeta) {
		tarjetas.add(tarjeta);
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
		objetivo = objetivoAsignado;
	}

	public boolean cumplioObjetivo() {
		return objetivo.seCumpleObjetivo(this);
	}

	public boolean esDestruido() {
		return (this.paises.size() == 0);
	}

	public boolean tieneMinimoPaises() {
		return (this.paises.size() >= minimoPaises);
	}

	public boolean conquistaContinentes(List<Continente> continentes) {
		for (int i = 0; i < continentes.size(); i++) {
			if(!(this.verificarConquista(continentes.get(i)))) {
				return false;
			}
		}
		return true;
	}

	public String colorDeJugador() {
		return this.color;
	}

	public boolean verificarConquista(Continente continente) {
		return conquistaPaises(continente.paises());
	}

	public boolean conquistaPaises(List<IPais> paisesParaConquistar) {
		for (int i = 0; i < paisesParaConquistar.size(); i++) {
			for (int j = 0 ; j < paises.size() ; j++) {
				if(!(paises.get(j).obtenerNombre().equals(paisesParaConquistar.get(i).obtenerNombre()))) {
					return false;
				}
			}
		}
		return true;
	}

}
