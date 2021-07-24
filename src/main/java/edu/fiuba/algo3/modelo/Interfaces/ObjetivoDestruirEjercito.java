package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoDestruirEjercito implements IObjetivo{

    public boolean seCumpleObjetivo(Jugador jugadorADestruir) {
        return jugadorADestruir.esDestruido(jugadorADestruir.paises);
    }

}
