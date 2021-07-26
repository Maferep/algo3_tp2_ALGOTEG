package edu.fiuba.algo3.modelo.Interfaces;

import java.util.NoSuchElementException;

public interface ITurno {

    public IJugador jugadorActual() ;

    public void siguienteJugador() ;

    public int cantidadDeJugadores() ;

    public IJugador jugadorDeColor(String color) throws NoSuchElementException;
}