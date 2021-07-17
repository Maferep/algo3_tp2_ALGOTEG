package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.*;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase() throws FaseIncompletaException;

	Boolean esFinDeJuego();

	IFaseInicio asFaseInicio() throws FaseErroneaException;

	IFaseAtacar asFaseAtacar() throws FaseErroneaException;
}
