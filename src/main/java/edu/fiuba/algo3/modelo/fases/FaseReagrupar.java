package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseReagrupar extends FaseAbstracta {

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
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        return estrategia.siguienteFase(turno, null);
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
