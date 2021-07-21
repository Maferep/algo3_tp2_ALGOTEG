package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Pais {
    String nombre;
    int ejercitos;
    Jugador conquistador;
    Continente continente;

	public Pais(String n) {
		this.nombre = n;
		this.ejercitos = 0;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public int cantidadEjercitos() {
		return ejercitos;
	}

	public void agregarEjercitos(int cantidadEjercitos) {
        ejercitos += cantidadEjercitos;
	}

	public void quitarEjercitos(long cantidadEjercitos) {
		ejercitos -= cantidadEjercitos;
	}

	public void asignarConquistador(Jugador conquistador) {
		this.conquistador = conquistador;
		conquistador.asignarPais(this);
		conquistador.continente.agregarPais();
	}

	public void asignarContinente(Continente continenteAsignado) { //IContinente
		continente = continenteAsignado;
	}

	public Jugador obtenerConquistador() { return this.conquistador; }

	public void atacar(Pais defensor, int numeroEjercitos) throws Exception {
		IAtaque ataque = new Ataque(this, defensor, numeroEjercitos);
		atacar(ataque);
	}

	public void atacar(IAtaque ataque) {
		ataque.atacar();
	}
}