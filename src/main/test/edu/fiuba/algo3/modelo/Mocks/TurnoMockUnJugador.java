package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

public class TurnoMockUnJugador implements ITurno {
    Jugador miJugador = new Jugador("Color");

    public TurnoMockUnJugador(List<Pais> paises) throws EjercitosException {
        miJugador = new Jugador("Color");
        miJugador.agregarEjercitos(3);
        miJugador.paises = paises;
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
    
}