package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar();

	public Boolean faseCompletada();

	public void siguienteJugador(ITurno turno);

	public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException;
}
