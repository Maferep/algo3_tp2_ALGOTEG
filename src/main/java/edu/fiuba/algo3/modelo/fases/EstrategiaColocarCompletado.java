package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaColocarCompletado implements IEstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return this;
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase(ITurno turno, List<Pais> paises, Canje canje) throws FaseIncompletaException {
        return new FaseAtacar(turno, paises, canje);
    }
}
