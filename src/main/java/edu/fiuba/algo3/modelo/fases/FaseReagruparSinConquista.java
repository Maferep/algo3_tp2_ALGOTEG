package edu.fiuba.algo3.modelo.fases;

import java.beans.PropertyChangeEvent;
import java.util.List;

import edu.fiuba.algo3.modelo.Canje;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Objetivo;

public class FaseReagruparSinConquista extends FaseReagrupar {

    public FaseReagruparSinConquista(ITurno turno, IMapa paises, Canje canje) {
        super(turno, paises, canje);
    }

    @Override
    public Objetivo obtenerObjetivo() {
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        finDeJuego = (Boolean) event.getNewValue();
    }
}
