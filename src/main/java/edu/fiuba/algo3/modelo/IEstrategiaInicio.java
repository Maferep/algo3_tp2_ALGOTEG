package edu.fiuba.algo3.modelo;

public interface IEstrategiaInicio {

	IEstrategiaInicio actualizar();

	void ubicarEjercitos(int cantEjercitos);

	Boolean faseCompletada();

	void asignarColores();

}
