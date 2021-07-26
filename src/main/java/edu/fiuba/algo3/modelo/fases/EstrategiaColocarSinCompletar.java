package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Interfaces.*;

public class EstrategiaColocarSinCompletar extends EstrategiaFaseSinCompletar {
    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return new EstrategiaColocarCompletado();
    }
}
