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

	static int minimoPaises = 30;

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

	public boolean conquistaContinentes(Jugador conquistador,List<Continente> continentes) {
		for (int i = 0; i < continentes.size(); i++) {
			if(!(conquistador.verificarConquista(continentes.get(i)))) {
				return false;
			}
		}
		return true;
	}

	public boolean conquistaPaises(Jugador conquistador,List<Pais> paises) {
		for (int i = 0; i < paises.size(); i++) {
			if(!paises.get(i).conquistador.color.equals(conquistador.color)) {
				return false;
			}
		}
		return true;
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

	public boolean cumpleObjetivoDeConquistarNContinentes(Jugador jugador, List<Continente> continentes) {
		Objetivo nuevoObjetivo = new Objetivo();
		return (nuevoObjetivo.objetivoConquistarContinenteCumplido(jugador,continentes));
	}

	public boolean cumpleObjetivoDeConquistarNPaises(Jugador jugador, List<Pais> paises) {
		Objetivo nuevoObjetivo = new Objetivo();
		return (nuevoObjetivo.objetivoConquistarPaisesCumplido(jugador,paises));
	}

	public boolean esDestruido(List<Pais> paises) {
		for(int i = 0 ; i < paises.size() ; i++) {
			if(paises.get(i).conquistador.color.equals(this.color)) {
				return false;
			}
		}
		return true;
	}

	public boolean tieneMinimoPaises() {
		return (this.paises.size() >= minimoPaises);
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
