package edu.fiuba.algo3.modelo.Interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar();

	public Boolean faseCompletada();

	public IFase siguienteFase(Turno turno, List<Pais> paises) throws FaseIncompletaException;
}
