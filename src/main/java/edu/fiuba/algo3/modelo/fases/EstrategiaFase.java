package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class EstrategiaFase implements IEstrategiaFase {
    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return this;
    }

    @Override
    public void siguienteJugador(ITurno turno) throws TurnoException, FaseIncompletaException {
        if(turno.esUltimoJugador()) 
            throw new TurnoException(null);
        turno.siguienteJugador();
    }

    @Override
    public IFase siguienteFase(ITurno turno, IFabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException, TurnoException {
        throw new FaseIncompletaException("No se puede seguir aun a la siguiente fase.");
    }
}
