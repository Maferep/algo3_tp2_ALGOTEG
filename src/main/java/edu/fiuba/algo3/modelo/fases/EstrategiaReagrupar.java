package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Interfaces.*;


public class EstrategiaReagrupar extends EstrategiaFaseCompleta {
    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return this;
    }
}
