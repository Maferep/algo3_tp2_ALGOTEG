package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public interface IJugador {

    List<Jugador> construirJugadores(List<String> colores, int cantidad) throws EjercitosException;

    private List<Jugador> jugadoresDeColores(List<String> colores) {
        return colores.stream()
                .map(c -> new Jugador(c))
                .collect(Collectors.toList());
    }

    void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException;

    void asignarPaisesAJugadores(List<Pais> paises, List<Jugador> jugadores);
}
