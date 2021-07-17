package edu.fiuba.algo3.modelo;

import java.util.*;

public class Turno {
    int [] numeroDeTurnos;
    List<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
    List<Jugador> jugadoresNoOrdenados = new ArrayList<Jugador>();

    public void determinarTurnos(List<Jugador> jugadores) {
        for(int i = 0 ; i < jugadores.size() ; i++) {
            numeroDeTurnos[i] = jugadores.get(i).numeroDeTurno();
            jugadoresNoOrdenados.add(jugadores.get(i));
        }
        this.ordenarAscendentemente();
        this.ordenarJugadoresPorTurno(jugadores);
    }

    public void ordenarAscendentemente() {
        Arrays.sort(numeroDeTurnos); //de menor a mayor: ascendente
    }

    public void ordenarJugadoresPorTurno(List<Jugador> jugadores) {
        for(int i = 0 ; i < jugadores.size() ; i++) {
            for(int j = 0 ; j < jugadores.size() ; j++) {
                if((jugadoresNoOrdenados.get(j)).numeroDeTurno() == numeroDeTurnos[i]) {
                    jugadoresOrdenados.add(jugadoresNoOrdenados.get(j));
                }
            }
        }
    }
}
