package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoGeneral implements IObjetivo {

    //objetivo general
    public boolean seCumpleObjetivo(Jugador jugadorActual) {
        return jugadorActual.tieneMinimoPaises();
    }

}
