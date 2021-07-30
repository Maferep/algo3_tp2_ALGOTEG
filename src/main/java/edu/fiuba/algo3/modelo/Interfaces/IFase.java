package edu.fiuba.algo3.modelo.Interfaces;

import java.beans.PropertyChangeListener;

import edu.fiuba.algo3.modelo.FabricaDeFases;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException, TurnoException;

	public void siguienteTurno() throws TurnoException, FaseIncompletaException;

	Boolean esFinDeJuego();

	FaseInicio obtenerFaseInicio() throws FaseErroneaException;

	FaseAtacar obtenerFaseAtacar() throws FaseErroneaException;

	FaseColocar obtenerFaseColocar() throws FaseErroneaException;

	FaseReagrupar obtenerFaseReagrupar() throws FaseErroneaException;
}
