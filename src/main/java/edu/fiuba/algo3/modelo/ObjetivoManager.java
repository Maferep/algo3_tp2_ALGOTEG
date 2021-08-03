package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjetivoManager {
    private List<IObjetivo> objetivosSecretos = new ArrayList<>();
    private List<IObjetivo> objetivosDeJugadores = new ArrayList<>();
    public ObjetivoManager(ITurno turno, List<IObjetivo> objetivosCreados) throws ObjetivoException {
        this.objetivosSecretos = objetivosCreados;
        this.asignarObjetivos(turno);
    }

    private void asignarObjetivos(ITurno turno) throws ObjetivoException {
        if(objetivosSecretos.size() < turno.cantidadDeJugadores()) 
            throw new ObjetivoException("No hay suficientes objetivos para iniciar el juego");
        
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo(objetivosSecretos.get(i));
            objetivosDeJugadores.add(objetivosSecretos.get(i));

            IObjetivo general = new ObjetivoGeneral();
            turno.jugadorActual().asignarObjetivo(general);
            objetivosDeJugadores.add(general);

            
            turno.siguienteJugador();
        }
    }
    /*
        Suscribe al Listener recibido a todos los objetivos
    */
    public void agregarSuscriptorAVictoria(PropertyChangeListener suscriptor) {
        for(IObjetivo objetivo : objetivosDeJugadores)
            objetivo.agregarSuscriptor(suscriptor);
    }

    /*
        Devuelve una lista de los nombres de los objetivos de cada jugador,
        en orden, desde el primer jugador.
    */
    public List<String> nombresDeObjetivos() {
        return objetivosSecretos 
            .stream()
            .map(o -> o.toString())
            .collect(Collectors.toList());
    }
}
