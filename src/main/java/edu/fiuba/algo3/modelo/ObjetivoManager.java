package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoManager {
    List<IObjetivo> objetivos;
    
	private List<PropertyChangeListener> suscriptores = new ArrayList<PropertyChangeListener>();


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

    public void agregarSuscriptorAVictoria(PropertyChangeListener suscriptor) {
        suscriptores.add(suscriptor);
    }

    public void notificarVictoria(IObjetivo objetivo, IJugador ganador) throws ObjetivoException {
        for(IObjetivo miObjetivo : objetivos)
            if(miObjetivo.equals(objetivo)){
                notificarVictoriaASuscriptores(ganador, objetivo);
                return;
            }
        throw new ObjetivoException("Se logro un objetivo invalido");
    }

    //COMENTARIO
    private void notificarVictoriaASuscriptores(IJugador ganador, IObjetivo objetivo) {
        //TODO: crear objetivo.toString() para poder escribir el tipo de objetivo
		for (PropertyChangeListener suscriptor : suscriptores) {
			PropertyChangeEvent evento = new PropertyChangeEvent(this, "ganador", null, ganador);
			suscriptor.propertyChange(evento);
		}
	}
}
