package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.modelo.Interfaces.ITurno;

public class Turno implements ITurno {
    private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

    public Turno(List<Jugador> jugadores) {
        this.jugadores.addAll(jugadores);
        definirPrimerJugador(jugadores.get((int) (Math.random() % jugadores.size())));
    }

    private void definirPrimerJugador(Jugador jugador) {
        while(jugadorActual() != jugador) 
            siguienteJugador();
    }

    public Jugador jugadorActual() {
        return jugadores.peekFirst();
    }

    public void siguienteJugador() {
        Jugador j = jugadores.removeFirst();
        jugadores.add(j);
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }
}
