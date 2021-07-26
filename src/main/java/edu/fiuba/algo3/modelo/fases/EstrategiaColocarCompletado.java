package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaColocarCompletado extends EstrategiaFase {
    @Override
    public IFase siguienteFase(ITurno turno, FabricaDeFases fabrica) throws FaseIncompletaException, TurnoException {
        if(!turno.esUltimoJugador())
            throw new TurnoException("Solo el ultimo jugador puede avanzar fases");
        return fabrica.crearFaseAtacar();
    }
}
