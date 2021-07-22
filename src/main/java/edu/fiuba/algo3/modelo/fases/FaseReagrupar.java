package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class FaseReagrupar extends FaseAbstracta {

    IEstrategiaFase estrategia = new EstrategiaReagruparSinCompletar();
    ITurno turno;
    List<IPais> paises;
    private Canje canje;

    public FaseReagrupar(ITurno turno, List<IPais> paises, Canje canje) {
        this.turno = turno;
        this.paises = paises;
        this.canje = canje;
    }
    public void reagrupar() {
        // TODO reagrupar
        estrategia = estrategia.actualizar();
    }

    // métodos de fase
    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException, EjercitosException {
        return estrategia.siguienteFase(turno, paises, canje);
    }

    @Override
    public Boolean esFinDeJuego() {
        return false;
    }

    @Override
    public FaseReagrupar asFaseReagrupar() {
        return this;
    }

}
