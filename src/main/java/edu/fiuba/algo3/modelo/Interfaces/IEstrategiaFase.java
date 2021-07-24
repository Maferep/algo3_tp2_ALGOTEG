package edu.fiuba.algo3.modelo.Interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar();

	public Boolean faseCompletada();

	public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException;
}
