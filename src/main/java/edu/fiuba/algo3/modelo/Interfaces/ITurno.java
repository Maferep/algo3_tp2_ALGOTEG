package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Jugador;

public interface ITurno {

    public Jugador jugadorActual() ;

    public void siguienteJugador() ;

    public int cantidadDeJugadores() ;
}