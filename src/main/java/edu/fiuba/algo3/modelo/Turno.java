package edu.fiuba.algo3.modelo;

import java.util.*;

public class Turno {
    ArrayList<Integer> turnosDeJugadores = new ArrayList<>();
    //Dictionary<Integer, Jugador> turnosDeJugadores;
    public void determinarTurnos(List<Jugador> jugadores) {
        for(int i = 0 ; i < jugadores.size() ; i++) {
            turnosDeJugadores.add(jugadores.get(i).numeroDeTurno(),jugadores.get(i));
        }
        this.ordenarAscendentemente();
    }

    public void ordenarAscendentemente() {
        Arrays.sort(turnosDeJugadores); //de menor a mayor: ascendente
    }

}
