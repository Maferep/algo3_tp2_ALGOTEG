package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjetivoManager {
    List<IObjetivo> objetivos;
    public ObjetivoManager(ITurno turno, List<IObjetivo> objetivosCreados) throws ObjetivoException {
        this.objetivos = objetivosCreados;
        this.asignarObjetivos(turno);
    }

    private void asignarObjetivos(ITurno turno) throws ObjetivoException {
        if(objetivos.size() < turno.cantidadDeJugadores()) 
            throw new ObjetivoException("No hay suficientes objetivos para iniciar el juego");
        
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo(objetivos.get(i));
            turno.siguienteJugador();
        }
    }
    /*
        Suscribe al Listener recibido a todos los objetivos
    */
    public void agregarSuscriptorAVictoria(PropertyChangeListener suscriptor) {
        for(IObjetivo objetivo : objetivos)
            objetivo.agregarSuscriptor(suscriptor);
    }

    /*
        Devuelve una lista de los nombres de los objetivos de cada jugador,
        en orden, desde el primer jugador.
    */
    public List<String> nombresDeObjetivos() {
        return objetivos.stream().map(o -> o.toString()).collect(Collectors.toList());
    }
}
