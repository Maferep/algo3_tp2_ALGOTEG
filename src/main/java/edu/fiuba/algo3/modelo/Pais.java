package edu.fiuba.algo3.modelo;

public class Pais {
    String nombre;
    int ejercitos;

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

	public Boolean atacar(Pais defensor, int cantEjercitos,Ataque tipoAtaque) {
		return tipoAtaque.atacar(this, defensor,cantEjercitos);
	}
}