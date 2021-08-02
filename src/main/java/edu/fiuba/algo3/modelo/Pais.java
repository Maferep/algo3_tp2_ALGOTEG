package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import java.util.ArrayList;
import java.util.List;

public class Pais implements IPais {
    String nombre;
    int ejercitos;
    IJugador conquistador;
    List<IPais> adyacentes;

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
	/*
		Asigna el pais a su conquistador y viceversa.
	*/
	public void definirConquistador(IJugador conquistador) {
		conquistador.asignarPais(this);
		this.conquistador = conquistador;
	}

	public void conquistar(IPais defensor) {
		(defensor.obtenerConquistador()).quitarPais(defensor);
        defensor.definirConquistador(conquistador);
	}

	public IJugador obtenerConquistador() { return this.conquistador; }

	public void atacar(IPais defensor, int numeroEjercitos) throws Exception {
		if(!adyacentes.stream().anyMatch(a -> a == defensor)) 
			//TODO crear excepción de adyacencia
			throw new Exception("No es adyacente");
		IAtaque ataque = new Ataque(this, defensor, numeroEjercitos);
		atacar(ataque);
	}

	public void atacar(IAtaque ataque) {
		ataque.atacar();
	}

	public void agregarAdyacente(IPais pais) { adyacentes.add(pais); }

	public void transferirEjercitosA(int cantidad, IPais otroPais) throws TransferirEjercitosException {
		if(!adyacentes.stream().anyMatch(a -> a == otroPais)) 
			throw new TransferirEjercitosException("No es adyacente");

		if(cantidad >= ejercitos)
			throw new TransferirEjercitosException("No hay tantos ejercitos para transferir");
	
		quitarEjercitos(cantidad);
		otroPais.agregarEjercitos(cantidad);
	}

	@Override
	public Boolean esAdyacenteA(IPais otroPais) {
		return adyacentes.contains(otroPais);
	}

	public boolean sonMismoPais(IPais pais) {
		return ((IPais) pais).obtenerNombre().equals(obtenerNombre());
	}

	@Override
	public List<IPais> obtenerAdyacentes() {
		return adyacentes;
	}
}