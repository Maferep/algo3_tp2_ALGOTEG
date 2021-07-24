package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;

import java.util.List;

public class Objetivo {

    public Objetivo(ITurno turno) {
        this.asignarObjetivos(turno);
    }

    public void asignarObjetivos(ITurno turno) {
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++) {
            turno.jugadorActual().asignarObjetivo();
            turno.siguienteJugador();
        }
    }

    //objetivo general
    public boolean objetivoGeneralCumplido(Jugador jugadorActual) {
        return jugadorActual.tieneMinimoPaises();
    }

    //objetivo destruir ejercito
    public boolean objetivoDestruirEjercitoCumplido(Jugador jugadorADestruir, List<IPais> paises) {
        return jugadorADestruir.esDestruido(paises);
    }

    //objetivo conquistar continentes
    public boolean objetivoConquistarContinenteCumplido(Jugador jugadorActual, List<Continente> continentes) {
        return jugadorActual.conquistaContinentes(jugadorActual,continentes);
    }


}
