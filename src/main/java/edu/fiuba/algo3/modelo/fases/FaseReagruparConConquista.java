package edu.fiuba.algo3.modelo.fases;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class FaseReagruparConConquista extends FaseReagrupar {
    public FaseReagruparConConquista(ITurno turno, IMapa paises, Mazo mazo) {
        super(turno, paises, mazo);
        turno
            .jugadorActual()
            .agregarTarjetaAleatoria(
                mazo.obtenerTarjeta()
            );
    }
}

