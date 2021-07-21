package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.List;

import edu.fiuba.algo3.modelo.*;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar();

	public Boolean faseCompletada();

	public IFase siguienteFase(Turno turno, List<Pais> paises) throws FaseIncompletaException;
}
