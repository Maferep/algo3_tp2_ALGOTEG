package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
	String color;
	List<Pais> paises;
	int ejercitos;

	public Jugador(String colorDelJugador) {
		color = colorDelJugador;
		paises = new ArrayList<Pais>();
		ejercitos = 0;
	}

	public void asignarPaises(int cantidadJugadores) {
		for(int i = 0 ; i < cantidadJugadores ; i++) {
			//leer archivo
		//	paises.add();
					//pais del archivo leido
		}
	}

	public Object obtenerNombre() {
		return color;
	}

	public List<Pais> obtenerPaises() {
		return this.paises;
	}

	public int cantidadEjercitos() {
		return ejercitos;
	}

	public void agregarEjercitos(int cantidad) throws Exception {
		if(cantidad <= 0)
			throw new Exception();
		ejercitos += cantidad;
	}

	public void asignarPais(Pais pais) {
		paises.add(pais);
	}

	public void asignarEjercitosAPais(int cantidad, Pais pais) throws Exception {
		if(cantidad > ejercitos)
			throw new FichasInsuficientesError("El jugador no tiene suficientes fichas.");
		if (!paises.contains(pais)) 
			throw new Exception();
	}

}
