package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaReagruparSinCompletar extends EstrategiaFaseSinCompletar {
    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return new EstrategiaReagruparCompletado();
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }
}
