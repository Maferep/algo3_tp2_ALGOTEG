package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Interfaces.*;

public class EstrategiaColocarSinCompletar extends EstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return new EstrategiaColocarCompletado();
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }
}
