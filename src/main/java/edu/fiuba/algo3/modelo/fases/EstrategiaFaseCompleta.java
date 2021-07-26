package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class EstrategiaFaseCompleta extends EstrategiaFase {

    @Override
    public void siguienteJugador(ITurno turno) throws TurnoException {
        if(turno.esUltimoJugador()) 
            throw new TurnoException(null);
        turno.siguienteJugador();
    }
}
