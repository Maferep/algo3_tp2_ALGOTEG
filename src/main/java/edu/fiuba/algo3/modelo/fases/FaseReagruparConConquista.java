package edu.fiuba.algo3.modelo.fases;

//<<<<<<< HEAD
import java.beans.PropertyChangeEvent;
import java.util.List;

//import edu.fiuba.algo3.modelo.Canje;
//=======
import edu.fiuba.algo3.modelo.Mazo;
//>>>>>>> canjes
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.ObjetivoManager;

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
