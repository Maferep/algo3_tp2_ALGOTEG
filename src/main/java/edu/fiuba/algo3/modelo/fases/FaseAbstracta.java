package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class FaseAbstracta implements IFase {
    List<IPais> paises;
    ITurno turno;
    Canje canje;
    
    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }
    
}