package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Objetivo {

    ObjetivoDestruirEjercito objetivoDestruirEjercito = new ObjetivoDestruirEjercito();
    ObjetivoConquistarPaisesYContinentes objetivoConquistarPaisesYContinentes = new ObjetivoConquistarPaisesYContinentes();
    ObjetivoGeneral objetivoGeneral = new ObjetivoGeneral();

    List <IObjetivo> objetivos = new ArrayList<IObjetivo>();

    public Objetivo(ITurno turno) {
        this.asignarObjetivos(turno);
    }

    public void asignarObjetivos(ITurno turno) {
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo(objetivos.get(i));
            turno.siguienteJugador();
        }
    }

}
