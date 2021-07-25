package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

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
