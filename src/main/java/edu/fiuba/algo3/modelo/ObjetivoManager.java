package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjetivoManager {
    private List<IObjetivo> objetivosCreados;
    private List<IObjetivo> objetivosDeJugadores = new ArrayList<>();
    public ObjetivoManager(ITurno turno, List<IObjetivo> objetivosCreados) throws ObjetivoException {
        this.objetivosCreados = objetivosCreados;
        this.asignarObjetivos(turno);
    }

    private void asignarObjetivos(ITurno turno) throws ObjetivoException {
        if(objetivosCreados.size() < turno.cantidadDeJugadores()) 
            throw new ObjetivoException("No hay suficientes objetivos para iniciar el juego");
        
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo(objetivosCreados.get(i));
            objetivosDeJugadores.add(objetivosCreados.get(i));
            objetivosDeJugadores.add(new ObjetivoGeneral());
            turno.siguienteJugador();
        }
    }
    /*
        Suscribe al Listener recibido a todos los objetivos
    */
    public void agregarSuscriptorAVictoria(PropertyChangeListener suscriptor) {
        for(IObjetivo objetivo : objetivosCreados)
            objetivo.agregarSuscriptor(suscriptor);
    }

    /*
        Devuelve una lista de los nombres de los objetivos de cada jugador,
        en orden, desde el primer jugador.
    */
    public List<String> nombresDeObjetivos() {
        return objetivosDeJugadores 
            .stream()
            .map(o -> o.toString())
            .collect(Collectors.toList());
    }
}
