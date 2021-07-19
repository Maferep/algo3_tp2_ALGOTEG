package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
	String color;
	List<Pais> paises;
	int ejercitos;
	int numeroDeTurno;
	Continente continente = new Continente();

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

	public boolean conquistaContinente(Jugador conquistador,Continente continente) {
		return conquistador.verificarConquista(continente);
	}

	public String obtenerColor() {
		return color;
	}

	public List<Pais> obtenerPaises() {
		return this.paises;
	}

	public int cantidadEjercitos() {
		return ejercitos;
	}

	public void agregarEjercitos(int cantidad) throws EjercitosException {
		if(cantidad <= 0)
			throw new EjercitosException(null);
		ejercitos += cantidad;
	}

	public void asignarPais(Pais pais) {
		paises.add(pais);
	}

	public boolean verificarConquista(Continente continente) {
		return this.continente.verificarConquista(continente);
	}

	public boolean cumpleObjetivoGeneral() {
		Objetivo nuevoObjetivo = new Objetivo();
		return (nuevoObjetivo.objetivoGeneralCumplido(this));
	}

	public boolean cumpleObjetivoDeDestruirAUnEjercitoEspecifico(Jugador jugadorADestruir, List<Pais> paises) {
		Objetivo nuevoObjetivo = new Objetivo();
		return (nuevoObjetivo.objetivoDestruirEjercitoCumplido(jugadorADestruir, paises));
	}

	public boolean esDestruido(List<Pais> paises) {
		for(int i = 0 ; i < paises.size() ; i++) {
			if(paises.get(i).conquistador.color.equals(this.color)) {
				return false;
			}
		}
		return true;
	}

	public void asignarEjercitosAPais(int cantidad, Pais pais) throws Exception {
		if(cantidad > ejercitos)
			throw new FichasInsuficientesError("El jugador no tiene suficientes fichas.");
		if (!paises.contains(pais)) 
			throw new Exception();
	}

	public void asignarNumeroParaTurno() {
		numeroDeTurno = (((int)(Math.random()*6))+1);
	}

	public void asignarNumeroParaTurnoMock(int numeroTurno) {
		numeroDeTurno = numeroTurno;
	}

	public int numeroDeTurno() {
		return numeroDeTurno;
	}

}
