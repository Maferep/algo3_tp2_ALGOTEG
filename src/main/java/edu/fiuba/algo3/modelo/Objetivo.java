package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivosInsuficientesException;

import java.util.ArrayList;
import java.util.List;

public class Objetivo {
    List<IObjetivo> objetivos = new ArrayList<>();

    public Objetivo(ITurno turno, List<IObjetivo> objetivosCreados) throws ObjetivosInsuficientesException {
        this.objetivos.addAll(objetivosCreados);
        this.asignarObjetivos(turno);
    }

    public void asignarObjetivos(ITurno turno) throws ObjetivosInsuficientesException {
        if(objetivos.size() < turno.cantidadDeJugadores()) {
            throw new ObjetivosInsuficientesException("No hay suficientes objetivos para iniciar el juego");
        }
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo(objetivos.get(i));
            turno.siguienteJugador();
        }
    }
}
