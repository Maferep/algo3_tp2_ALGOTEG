package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JugadorFactoryMock implements IJugador {

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
    @Override
    public List<Jugador> construirJugadores(List<String> colores, int cantidad) throws EjercitosException {
        List<Jugador> jugadores = jugadoresDeColores(colores.subList(0, cantidad));
        asignarPaisesAJugadores(paises, jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }

    private List<Jugador> jugadoresDeColores(List<String> colores) {
        return colores.stream()
                .map(c -> new Jugador(c))
                .collect(Collectors.toList());
    }

    @Override
    public void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException {
        for(Jugador j : jugadores) {
            j.agregarEjercitos(cantidadEjercitos);
        }
    }
    //corregir edto
    @Override
    public void asignarPaisesAJugadores(List<Pais> paises, List<Jugador> jugadores) {
        for(int j = 0 ; j < jugadores.size() ; j++) {
            for (int i = 0; i < paises.size(); i++) {
                Pais actual = paises.get(i);
                jugadores.get(j).asignarPais(actual);
            }
        }
    }
}
