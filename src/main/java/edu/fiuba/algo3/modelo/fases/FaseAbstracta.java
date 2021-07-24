package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class FaseAbstracta implements IFase {
    ITurno turno;
    Canje canje;
    
    @Override
    public FaseInicio obtenerFaseInicio() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseAtacar obtenerFaseAtacar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseColocar obtenerFaseColocar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseReagrupar obtenerFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public void siguienteTurno() {
        turno.siguienteJugador();
    }
    
}