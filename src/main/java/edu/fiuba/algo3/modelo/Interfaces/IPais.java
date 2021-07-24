package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;

public interface IPais {

	void agregarEjercitos(int i);

	IJugador obtenerConquistador();

	void atacar(IAtaque ataqueFalso);

	String obtenerNombre();

	void agregarAdyacente(IPais iPais);

	void quitarEjercitos(long cantDerrotas);

	void conquistar(IPais defensor);

	int cantidadEjercitos();

	void atacar(IPais defensor, int cantidadDeSoldados) throws Exception;

	void definirConquistador(IJugador jugador2);
	
	public void transferirEjercitosA(int cantidad, IPais otroPais) throws TransferirEjercitosException;
}