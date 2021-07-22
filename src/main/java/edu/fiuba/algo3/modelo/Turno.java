package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;

public class Turno implements ITurno {
    private LinkedList<IJugador> jugadores = new LinkedList<IJugador>();

    public Turno(List<IJugador> list) {
        this.jugadores.addAll(list);
        definirPrimerJugador(list.get((int) (Math.random() % list.size())));
    }

    private void definirPrimerJugador(IJugador iJugador) {
        while (jugadorActual() != iJugador)
            siguienteJugador();
    }

    public IJugador jugadorActual() {
        return jugadores.peekFirst();
    }

    public void siguienteJugador() {
        IJugador j = jugadores.removeFirst();
        jugadores.add(j);
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }
}
