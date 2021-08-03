package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;
import java.util.NoSuchElementException;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;

public class TurnoMockUnJugador implements ITurno {
    Jugador miJugador = new Jugador("Color");

    public TurnoMockUnJugador(List<IPais> paises) throws EjercitosException {
        miJugador = new Jugador("Color");
        miJugador.inicializarEjercitos(8);
        for(IPais p : paises) {
            miJugador.inicializarPais(p);
        }
    }

    public Jugador jugadorActual() {
        return miJugador;
    }

    @Override
    public void siguienteJugador() {
    }

    @Override
    public int cantidadDeJugadores() {
        return 1;
    }

    @Override
    public boolean esUltimoJugador() {
        return true;
    }
    public IJugador jugadorDeColor(String color) throws NoSuchElementException {
        return miJugador;
    }

    @Override
    public List<String> obtenerColores() {
        // TODO Auto-generated method stub
        return null;
    }

    public void actualizarListaDeJugadoresAlCambiarDeFase() {
        this.siguienteJugador();
    }

    @Override
    public IJugador obtenerGanador() throws TurnoException {
        if(miJugador.cumplioObjetivo()) return miJugador;
        else throw new TurnoException("No hay ganador aun.");
    }
}