package edu.fiuba.algo3.modelo.Mocks;

import java.util.*;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class TurnoMock implements ITurno {
    List<Jugador> jugadores = Arrays.asList(
        new Jugador("Rojo"), 
        new Jugador("Verde"), 
        new Jugador("Amarillo"));


    @Override
    public Jugador jugadorActual() {
        return jugadores.get(0);
    }

    @Override
    public void siguienteJugador() {
    }

    @Override
    public int cantidadDeJugadores() {
        return 1;
    }

}