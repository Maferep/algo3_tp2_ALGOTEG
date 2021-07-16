package edu.fiuba.algo3.modelo.Interfaces;

public interface IFaseInicio extends IFase {
	Integer cantidadDeJugadores();

	void asignarColores();

	void ubicarEjercitos(int i);
}
