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
	int ejercitos;
	public Continente continente = new Continente();

	static int minimoPaises = 30;

	public Jugador(String colorDelJugador) {
		color = colorDelJugador;
		paises = new ArrayList<IPais>();
		tarjetas = new ArrayList<Tarjeta>();
		ejercitos = 0;
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
		return ejercitos;
	}

	@Override
	public void agregarEjercitos(int cantidad) throws EjercitosException {
		if(cantidad <= 0)
			throw new EjercitosException(null);
		ejercitos += cantidad;
	}

	@Override
	public void agregarNuevosEjercitos(int cantidad) throws EjercitosException {
		this.ejercitos = 0;
		if(cantidad <= 0) throw new EjercitosException(null);
		// Si el jugador controla menos de seis países de todas maneras incorpora tres ejércitos.
		if(this.paises.size() < 6) {
			this.ejercitos += 3;
		}
		else {
			this.ejercitos += cantidad;
		}
	}

	public void asignarPais(IPais pais) {
		paises.add(pais);
	}

	public void quitarPais(IPais pais) {
		paises.remove(pais);
	}

	public void verificarPais(IPais pais) throws PaisNoExistenteError {
		for(int i = 0 ; i < paises.size() ; i++) {
			if( paises.get(i).obtenerNombre().equals(pais.obtenerNombre())) {
				return;
			}
		}
		throw new PaisNoExistenteError("El jugador no es conquistador del pais " + pais.obtenerNombre());
	}

	public void verificarCantidadDeEjercitos(int cantEjercitos) throws FichasInsuficientesError{
		if(cantEjercitos > this.cantidadEjercitos()) {
			throw new FichasInsuficientesError("No tienes esa cantidad de fichas para colocar en el pais");
		}
	}

	public void agregarTarjetaAleatoria(Tarjeta tarjeta) {
		tarjetas.add(tarjeta);
	}

}
