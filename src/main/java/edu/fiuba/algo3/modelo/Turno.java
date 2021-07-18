package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.Collectors;

public class Turno {
    private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
    //TODO: colores duplicado en etapa inicial. en espera de sistema de colores
    private List<String> colores = Arrays.asList("Azul", "Rojo", "Amarillo", "Verde");

    public Turno(int cantJugadores) {
        jugadores.addAll( 
            colores.stream()
                .limit(cantJugadores)
                .map(c -> new Jugador(c))
                .collect(Collectors.toList())
        );
    } 
    
    public Turno(List<String> colores) {
        jugadores.addAll( 
            colores.stream()
                .map(c -> new Jugador(c))
                .collect(Collectors.toList())
        );
    } 

    public Jugador jugadorActual() {
        return jugadores.peekFirst();
    }

    public void siguienteJugador() {
        Jugador j = jugadores.removeFirst();
        jugadores.add(j);
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }
}
