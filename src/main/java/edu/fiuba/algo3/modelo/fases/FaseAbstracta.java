package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class FaseAbstracta implements IFase {
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