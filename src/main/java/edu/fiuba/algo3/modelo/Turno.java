package edu.fiuba.algo3.modelo;

import java.util.*;

public class Turno {
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
