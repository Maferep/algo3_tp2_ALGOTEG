package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.Canje;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class FaseReagruparConConquista extends FaseReagrupar {

    public FaseReagruparConConquista(ITurno turno, IMapa paises, Canje canje) {
        super(turno, paises, canje);
        turno
            .jugadorActual()
            .agregarTarjetaAleatoria(
                canje.obtenerTarjeta()
            );
    }
}
