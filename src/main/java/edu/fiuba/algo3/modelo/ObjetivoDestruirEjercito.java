package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoDestruirEjercito implements IObjetivo{

    String colorDelJugadorADestruir;
    ITurno turnoActual;
    IJugador jugadorADestruir;

    public ObjetivoDestruirEjercito(String color, ITurno turno) {
        colorDelJugadorADestruir = color;
        turnoActual = turno;
    }

    public boolean seCumpleObjetivo(Jugador jugador) {
        for(int i = 0 ; i < turnoActual.cantidadDeJugadores() ; i++) {
            if(turnoActual.jugadorActual().colorDeJugador().equals(colorDelJugadorADestruir)) {
                jugadorADestruir = turnoActual.jugadorActual();
            }
            turnoActual.siguienteJugador();
        }
        if(jugadorADestruir == null) {
            jugadorADestruir = turnoActual.jugadorActual();
        }
        return jugadorADestruir.esDestruido();
    }
}
