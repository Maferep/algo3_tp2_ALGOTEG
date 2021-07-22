package edu.fiuba.algo3.modelo.Interfaces;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase() throws FaseIncompletaException, EjercitosException;

	public void siguienteTurno();

	Boolean esFinDeJuego();

	FaseInicio asFaseInicio() throws FaseErroneaException;

	FaseAtacar asFaseAtacar() throws FaseErroneaException;

	FaseColocar asFaseColocar() throws FaseErroneaException;

	FaseReagrupar asFaseReagrupar() throws FaseErroneaException;
}
