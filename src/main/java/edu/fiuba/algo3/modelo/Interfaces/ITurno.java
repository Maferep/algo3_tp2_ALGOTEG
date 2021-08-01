package edu.fiuba.algo3.modelo.Interfaces;

import java.util.List;
import java.util.NoSuchElementException;

public interface ITurno {

    public List<String> obtenerColores();

    public IJugador jugadorActual() ;

    public void siguienteJugador() ;

    public int cantidadDeJugadores() ;

	public boolean esUltimoJugador();
    public IJugador jugadorDeColor(String color) throws NoSuchElementException;

	public List<String> obtenerColores();
}