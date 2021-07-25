package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoDestruirEjercito implements IObjetivo{

    IJugador jugadorADestruir;

    public ObjetivoDestruirEjercito(ITurno turno) {
        turno.siguienteJugador();
        jugadorADestruir = turno.jugadorActual();
    }

    public boolean seCumpleObjetivo(Jugador jugador) {
        return jugadorADestruir.esDestruido(jugadorADestruir.obtenerPaises());
    }

}
