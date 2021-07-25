package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoDestruirEjercito implements IObjetivo{

    //IJugador jugadorADestruir;
    String colorDelJugadorADestruir;
    public ObjetivoDestruirEjercito(String color, ITurno turno) {
        colorDelJugadorADestruir = color;
    }

    public boolean seCumpleObjetivo(Jugador jugador) {
        return jugadorADestruir.esDestruido();
    }

}
