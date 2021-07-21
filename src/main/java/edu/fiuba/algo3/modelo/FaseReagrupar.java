package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseAtacar;
import edu.fiuba.algo3.modelo.FaseInicio;
import edu.fiuba.algo3.modelo.Interfaces.IEstrategiaFase;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.Interfaces.IFase;

public class FaseReagrupar implements IFase {

    IEstrategiaFase estrategia = new EstrategiaReagruparSinCompletar();
    Turno turno;
    public FaseReagrupar(IFase faseAnterior) { }
    public FaseReagrupar(IFase faseAnterior, Turno sistemaDeTurnos) {
        turno = sistemaDeTurnos;
    }
    public FaseReagrupar() {}
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
        return estrategia.siguienteFase(this, turno);
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
