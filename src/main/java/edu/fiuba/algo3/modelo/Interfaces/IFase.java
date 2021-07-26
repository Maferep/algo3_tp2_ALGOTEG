package edu.fiuba.algo3.modelo.Interfaces;
import edu.fiuba.algo3.modelo.FabricaDeFases;
import edu.fiuba.algo3.modelo.Objetivo;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

import java.beans.PropertyChangeListener;

public interface IFase extends PropertyChangeListener {

	Boolean faseCompletada();

	IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException;

	public void siguienteTurno();

	Boolean esFinDeJuego();

	FaseInicio obtenerFaseInicio() throws FaseErroneaException;

	FaseAtacar obtenerFaseAtacar() throws FaseErroneaException;

	FaseColocar obtenerFaseColocar() throws FaseErroneaException;

	FaseReagrupar obtenerFaseReagrupar() throws FaseErroneaException;

	Objetivo obtenerObjetivo();

	ITurno turno();
}
