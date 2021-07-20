package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

public class JugadorFactory {
    List<Pais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá", 
            "Brasil", 
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
        .stream()
        .map(n -> new Pais(n))
        .collect(Collectors.toList());
    int cantidadEjercitos = 8;

	public List<Jugador> construirJugadores(List<String> colores, int cantidad) throws EjercitosException {
		List<Jugador> jugadores = jugadoresDeColores(colores.subList(0, cantidad));
        asignarPaisesAleatoriamenteAJugadores(paises, jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }
    private List<Jugador> jugadoresDeColores(List<String> colores) {
        return colores.stream()
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
            j.agregarEjercitos(cantidadEjercitos);
        }
    }

}
