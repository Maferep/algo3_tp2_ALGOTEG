package edu.fiuba.algo3.modelo.Interfaces;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase();

	Boolean finDeJuego();

	void realizar();

}
