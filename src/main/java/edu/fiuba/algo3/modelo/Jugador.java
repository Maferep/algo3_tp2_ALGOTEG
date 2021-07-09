package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
	String nombre;
	List<Pais> paises;
	int ejercitos;

	public Jugador(String n) {
		nombre = n;
		paises = new ArrayList<Pais>();
		ejercitos = 0;
	}

	public Object obtenerNombre() {
		return nombre;
	}

	public List<Pais> obtenerPaises() {
		return this.paises;
	}

	public int cantidadEjercitos() {
		return ejercitos;
	}

	public int obtenerCantidadEjercitos() { return ejercitos; }

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
			throw new Exception();
		if (!paises.contains(pais)) 
			throw new Exception();
		
	}
	public void atacar(int cantidadSoldadosDefensor) {}

}
