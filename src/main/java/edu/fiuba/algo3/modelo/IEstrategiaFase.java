package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar() throws Exception;

	public Boolean faseCompletada();

	public IFase siguienteFase(IFase actual) throws FaseIncompletaException;
}
