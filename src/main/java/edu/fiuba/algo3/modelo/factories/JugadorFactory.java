package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import java.util.*;
import java.util.stream.*;

public class JugadorFactory {
    List<IPais> paises = Arrays.asList(
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

	public List<IJugador> construirJugadores(List<String> colores, int cantidad) throws EjercitosException {
		List<IJugador> jugadores = jugadoresDeColores(colores.subList(0, cantidad));
        asignarPaisesAJugadores(paises, jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }

    private List<IJugador> jugadoresDeColores(List<String> colores) {
        return colores.stream()
            .map(c -> new Jugador(c))
            .collect(Collectors.toList());
    }
    //se va a tener que leer el archivo de paises e ir cargandose en la lista.

    public void asignarPaisesAJugadores(List<IPais> paises, List<IJugador> jugadores) {
        Collections.shuffle(paises);
        for (int i = 0; i < paises.size(); i++) {
            IPais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).asignarPais(actual);
        }
    }

    public void asignarEjercitosAJugadores(List<IJugador> jugadores) throws EjercitosException {
        for (IJugador j : jugadores) {
            j.agregarEjercitos(cantidadEjercitos);
        }
    }

}
