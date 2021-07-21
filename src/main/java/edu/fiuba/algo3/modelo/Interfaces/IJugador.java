package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

import java.util.List;

public interface IJugador {

    List<Jugador> construirJugadores(List<String> colores, int cantidad) throws EjercitosException;

    void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException;

    void asignarPaisesAJugadores(List<Pais> paises, List<Jugador> jugadores);
}
