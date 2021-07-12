package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Pais {
    String nombre;
    int ejercitos;
    Jugador conquistador;

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
	}

	public Jugador obtenerConquistador() { 
		return this.conquistador; 
	}

	public void atacar(Pais defensor, int cantEjercitos, IAtaque tipoAtaque) {
		tipoAtaque.atacar();
	}
}