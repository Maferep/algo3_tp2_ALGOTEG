package edu.fiuba.algo3.modelo.Interfaces;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase() throws FaseIncompletaException, EjercitosException;

	public void siguienteTurno();

	Boolean esFinDeJuego();

	FaseInicio obtenerFaseInicio() throws FaseErroneaException;

	FaseAtacar obtenerFaseAtacar() throws FaseErroneaException;

	FaseColocar obtenerFaseColocar() throws FaseErroneaException;

	FaseReagrupar obtenerFaseReagrupar() throws FaseErroneaException;
}
