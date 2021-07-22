package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.Canje;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class FaseReagruparSinConquista extends FaseReagrupar {

    public FaseReagruparSinConquista(ITurno turno, List<IPais> paises, Canje canje) {
        super(turno, paises, canje);
    }
}
