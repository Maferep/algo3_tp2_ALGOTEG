package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoGeneral implements IObjetivo{

    //objetivo general
    public boolean seCumpleObjetivo(Jugador jugadorActual) {
        return jugadorActual.tieneMinimoPaises();
    }

}
