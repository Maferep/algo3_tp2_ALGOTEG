package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseReagrupar implements IFase {

    private List<Pais> paises;
    private Turno turno;

    public FaseReagrupar(Turno turno, List<Pais> paises) {
        this.turno = turno;
        this.paises = paises;
    }

    //métodos de colocar

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
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

}
