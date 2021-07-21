package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseReagrupar implements IFase {

    IEstrategiaFase estrategia = new EstrategiaReagruparSinCompletar();
    Turno turno;

    public FaseReagrupar(Turno turno, List<Pais> paises) {
        this.turno = turno;
    }
    public void reagrupar() {
        // TODO reagrupar
        estrategia = estrategia.actualizar();
    }

    // métodos de fase
    @Override
    public Boolean faseCompletada() {
        // TODO Auto-generated method stub
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        // TODO Auto-generated method stub
        return estrategia.siguienteFase(turno, null);
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase reagrupar");
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase reagrupar");
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase reagrupar");
    }

    @Override
    public FaseReagrupar asFaseReagrupar() {
        // TODO Auto-generated method stub
        return this;
    }

}
