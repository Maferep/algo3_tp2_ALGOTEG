package edu.fiuba.algo3.modelo.fases;

import java.beans.PropertyChangeEvent;
import java.util.List;

import edu.fiuba.algo3.modelo.Canje;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.ObjetivoManager;

public class FaseReagruparSinConquista extends FaseReagrupar {

    public FaseReagruparSinConquista(ITurno turno, IMapa paises, Canje canje) {
        super(turno, paises, canje);
    }

    @Override
    public ObjetivoManager obtenerObjetivo() {
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        finDeJuego = (Boolean) event.getNewValue();
    }
}
