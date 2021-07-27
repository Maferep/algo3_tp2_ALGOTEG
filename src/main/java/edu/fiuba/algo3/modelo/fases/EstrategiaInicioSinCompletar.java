package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Interfaces.*;

public class EstrategiaInicioSinCompletar extends EstrategiaFaseSinCompletar {

    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return new EstrategiaJuegoInicializado();
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }
}
