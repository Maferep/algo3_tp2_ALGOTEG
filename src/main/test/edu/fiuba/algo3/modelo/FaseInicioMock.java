package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

public class FaseInicioMock implements IFaseInicio, IFase {

    @Override
    public Boolean faseCompletada() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseReagruparConConquista asFaseReagrupar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

}
