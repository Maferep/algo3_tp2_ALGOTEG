package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EtapaInicial {
    List<Jugador> jugadores;
    List<String> colores = Arrays.asList("Azul","Rojo","Amarillo","Verde","Rosa","Negro");
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;
    static int cantidadEjercitos = 8; //la cantidad de ejercitos para cada jugador en la etapa inicial es 8
    static int cantidadInicial = 0;

    public EtapaInicial(int cantidadJugadores) throws Exception {
        if(cantidadJugadores < minimoJugadores || cantidadJugadores > maximoJugadores)
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + (minimoJugadores) + "y un máximo de" + (maximoJugadores) + ".");
        asignarJugadores(cantidadJugadores);
        //asignarTurnos(cantidadJugadores);
        //asignarPaisesAJugadores(cantidadJugadores);
        asignarEjercitosAJugadores(cantidadJugadores);
    }

    public void asignarJugadores(int cantidadJugadores) {
        jugadores = new ArrayList<Jugador>();
        for(int i = 0 ; i < cantidadJugadores ; i++ ) {
            Jugador jugador = new Jugador(colores.get(i));
            jugadores.add(jugador);
        }
    }

    public void asignarTurnos(int cantidadJugadores) {

    }

    public void asignarPaisesAJugadores(int cantidadJugadores) {
        for(int i = 0 ; i < cantidadJugadores ; i++ ) {
            (jugadores.get(i)).asignarPaises(cantidadJugadores);
        }
    }

    public void asignarEjercitosAJugadores(int cantidadJugadores) throws Exception {
        for(int i = 0 ; i < cantidadJugadores ; i++ ) {
            (jugadores.get(i)).agregarEjercitos(cantidadEjercitos);
        }
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    public Jugador jugadores(int i) throws Exception {
        if(i < cantidadInicial || i > cantidadDeJugadores())
            throw new Exception();
        return jugadores.get(i);
    }

}
