package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    String nombre;
    int ejercitos;
    Jugador conquistador;
    List<Pais> adyacentes;

	public Pais(String n) {
		this.nombre = n;
		this.ejercitos = 0;
		adyacentes = new ArrayList<Pais>();
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

	public Jugador obtenerConquistador() { return this.conquistador; }

	public void atacar(Pais defensor, int numeroEjercitos) throws Exception {
		IAtaque ataque = new Ataque(this, defensor, numeroEjercitos);
		atacar(ataque);
	}

	public void atacar(IAtaque ataque) {
		ataque.atacar();
	}

	public void agregarAdyacente(Pais pais) { adyacentes.add(pais); }

	public List<Pais> obtenerAdyacentes() { return adyacentes; }
}