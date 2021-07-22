package edu.fiuba.algo3.modelo.Interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.Continente;

public interface IPais {

	void agregarEjercitos(int i);

	IJugador obtenerConquistador();

	void atacar(IAtaque ataqueFalso);

	String obtenerNombre();

	void agregarAdyacente(IPais iPais);

	void quitarEjercitos(long cantDerrotas);

	void asignarConquistador(IJugador iJugador);

	int cantidadEjercitos();

	List<IPais> obtenerAdyacentes();

	void atacar(IPais defensor, int cantidadDeSoldados) throws Exception;
    
}