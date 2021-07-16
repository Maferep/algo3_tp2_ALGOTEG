package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import java.util.Arrays;
import java.util.List;

public class EtapaInicial {
    List<Jugador> jugadores;
    List<String> colores = Arrays.asList("Azul","Rojo","Amarillo","Verde","Rosa","Negro");
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;

    public EtapaInicial(int cantidadJugadores) throws Exception {
        if(cantidadJugadores < minimoJugadores || cantidadJugadores > maximoJugadores)
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + (minimoJugadores) + "y un máximo de" + (maximoJugadores) + ".");
        asignarJugadores(cantidadJugadores);
    }

    public void asignarJugadores(int cantidadJugadores) {
        for(int i = 0 ; i < cantidadJugadores ; i++ ) {
            Jugador jugador = new Jugador(colores.get(i));
            jugadores.add(jugador);
        }
    }

}
