package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;
import java.util.NoSuchElementException;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

public class TurnoMockUnJugador implements ITurno {
    Jugador miJugador = new Jugador("Color");

    public TurnoMockUnJugador(List<IPais> paises) throws EjercitosException {
        miJugador = new Jugador("Color");
        miJugador.inicializarEjercitos(8);
        for(IPais pais : paises)
            miJugador.asignarPais(pais);
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
    public IJugador jugadorDeColor(String color) throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }
    
}