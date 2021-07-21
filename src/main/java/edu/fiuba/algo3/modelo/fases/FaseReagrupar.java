package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseReagrupar extends FaseAbstracta {

    IEstrategiaFase estrategia = new EstrategiaReagruparSinCompletar();
    ITurno turno;
    List<Pais> paises;
    private Canje canje;

    public FaseReagrupar(ITurno turno, List<Pais> paises, Canje canje) {
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
    public IFase siguienteFase() throws FaseIncompletaException {
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
