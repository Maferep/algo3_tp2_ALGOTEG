package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;

public interface IEstrategiaFase {
	public Boolean faseCompletada();

	public IEstrategiaFase turnoCompleto(ITurno turno);

	public void siguienteJugador(ITurno turno) throws TurnoException, FaseIncompletaException;

	public IFase siguienteFase(ITurno turno, IFabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException, TurnoException;
}
