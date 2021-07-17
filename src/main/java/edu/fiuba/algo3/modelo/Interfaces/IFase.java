package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase() throws FaseIncompletaException;

	void realizar() throws Exception;

	Boolean esFinDeJuego();

}
