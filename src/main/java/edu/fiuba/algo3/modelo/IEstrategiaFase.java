package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar();

	Boolean faseCompletada();

	IFase siguienteFase() throws FaseIncompletaException;

	Boolean finDeJuego();

	void realizar();
}
