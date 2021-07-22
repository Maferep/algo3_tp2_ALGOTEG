package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Pais implements IPais {
    String nombre;
    int ejercitos;
    IJugador conquistador;
    List<IPais> adyacentes;
    Continente continente;

	public Pais(String n) {
		this.nombre = n;
		this.ejercitos = 0;
		adyacentes = new ArrayList<IPais>();
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

	public void asignarConquistador(IJugador conquistador) {
		this.conquistador = conquistador;
		conquistador.asignarPais(this);
		conquistador.continente.agregarPais();
	}

	public void asignarContinente(Continente continenteAsignado) { //IContinente
		continente = continenteAsignado;
	}

	public IJugador obtenerConquistador() { return this.conquistador; }

	public void atacar(IPais defensor, int numeroEjercitos) throws Exception {
		IAtaque ataque = new Ataque(this, defensor, numeroEjercitos);
		atacar(ataque);
	}

	public void atacar(IAtaque ataque) {
		ataque.atacar();
	}

	public void agregarAdyacente(IPais pais) { adyacentes.add(pais); }

	public List<IPais> obtenerAdyacentes() {
		return adyacentes;
	}
}