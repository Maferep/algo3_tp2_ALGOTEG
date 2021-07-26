package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.util.List;

public class ObjetivoManager {
    List<IObjetivo> objetivos;

    public ObjetivoManager(ITurno turno, List<IObjetivo> objetivosCreados) throws ObjetivoException {
        this.objetivos = objetivosCreados;
        this.asignarObjetivos(turno);
    }

    private void asignarObjetivos(ITurno turno) throws ObjetivoException {
        if(objetivos.size() < turno.cantidadDeJugadores()) {
            throw new ObjetivoException("No hay suficientes objetivos para iniciar el juego");
        }
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo(objetivos.get(i));
            turno.siguienteJugador();
        }
    }
}
