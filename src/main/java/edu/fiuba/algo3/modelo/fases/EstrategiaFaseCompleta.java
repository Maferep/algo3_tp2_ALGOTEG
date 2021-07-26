package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class EstrategiaFaseCompleta extends EstrategiaFase {

    @Override
    public void siguienteJugador(ITurno turno) throws TurnoException {
        if(turno.esUltimoJugador()) 
            throw new TurnoException("No puede avanzar si es ultimo jugador");
        turno.siguienteJugador();
    }

    public Boolean faseCompletada() {
        return true;
    }
    protected void verificarUltimoJugador(ITurno turno) throws TurnoException {
        if(!turno.esUltimoJugador())
            throw new TurnoException("No puede avanzar si no es ultimo jugador");
        turno.siguienteJugador();
    }
}
