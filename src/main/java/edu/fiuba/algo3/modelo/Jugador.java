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

	static int minimoPaises = 30;

	public Jugador(String colorDelJugador) {
		color = colorDelJugador;
		paises = new ArrayList<IPais>();
		tarjetas = new ArrayList<Tarjeta>();
		ejercitosPorColocar = 0;
	}

	//TODO programacion estructurada
	public boolean conquistaPaises(IJugador conquistador,List<IPais> paises) {
		for (int i = 0; i < paises.size(); i++) {
			if(!paises.get(i).obtenerConquistador().obtenerColor().equals(conquistador.obtenerColor())) {
				return false;
			}
		}
		return true;
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
		// Si el jugador controla menos de seis países de todas maneras incorpora tres ejércitos.
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

	public void asignarObjetivo() {

	}

	public boolean esDestruido(List<IPais> paises) {
		for(int i = 0 ; i < paises.size() ; i++) {
			if((paises.get(i)).obtenerConquistador().obtenerColor().equals(this.color)) {
				return false;
			}
		}
		return true;
	}

	public boolean tieneMinimoPaises() {
		return (this.paises.size() >= minimoPaises);
	}

	public boolean conquistaContinentes(Jugador conquistador,List<Continente> continentes) {
		for (int i = 0; i < continentes.size(); i++) {
			if(!(conquistador.verificarConquista(continentes.get(i)))) {
				return false;
			}
		}
		return true;
	}

	public boolean conquistaPaises(Jugador conquistador,List<IPais> paises) {
		for (int i = 0; i < paises.size(); i++) {
			if(!paises.get(i).obtenerConquistador().obtenerColor().equals(conquistador.color)) {
				return false;
			}
		}
		return true;
	}

}
