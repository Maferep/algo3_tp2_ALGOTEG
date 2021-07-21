package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import java.util.*;
import java.util.stream.*;

public class JugadorFactory implements IJugador {
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
    //se va a tener que leer el archivo de paises e ir cargandose en la lista.
    @Override
    public void asignarPaisesAJugadores(List<Pais> paises, List<Jugador> jugadores) {
        Collections.shuffle(paises);
        for (int i = 0; i < paises.size(); i++) {
            Pais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).asignarPais(actual);
        }
    }
    @Override
    public void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException {
        for(Jugador j : jugadores) {
            j.agregarEjercitos(cantidadEjercitos);
        }
    }

}
