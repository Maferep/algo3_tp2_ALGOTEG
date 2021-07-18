package edu.fiuba.algo3.modelo.builders;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class TurnoBuilder {

    List<Jugador> jugadores;

    //mover este dato a otra clase
    static int cantEjercitos = 8;

    public Turno crearTurno(List<String> colores, List<Pais> paises, int cantJugadores) throws EjercitosException {
        jugadores = jugadoresDeColores(colores.subList(0, cantJugadores));
        asignarPaisesAleatoriamenteAJugadores(paises, jugadores);
        asignarEjercitosAJugadores(jugadores);
        return new Turno(jugadores);
    }

    private List<Jugador> jugadoresDeColores(List<String> colores) {
        return jugadores = colores.stream()
            .map(c -> new Jugador(c))
            .collect(Collectors.toList());
    }
    private void asignarPaisesAleatoriamenteAJugadores(List<Pais> paises, List<Jugador> jugadores) {
        Collections.shuffle(paises);
        for (int i = 0; i < paises.size(); i++) {
            Pais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).asignarPais(actual);
        }
    }

    private void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException {
        for(Jugador j : jugadores) {
            j.agregarEjercitos(8);
        }
    }

}
