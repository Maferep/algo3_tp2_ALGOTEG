package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Interfaces.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TurnoTest {
    @Test
    public void test00JugadorConTurnoCorrecto() throws Exception {
        List<IJugador> jugadores = Arrays.asList(
                new Jugador("Azul"), 
                new Jugador("Rojo"), 
                new Jugador("Amarillo"),
                new Jugador("Verde"));
                
        ITurno turno = new Turno(jugadores);
        assertEquals(turno.cantidadDeJugadores(), 4);
        assertEquals(turno.jugadorActual().obtenerColor(), "Azul");
        
        turno.siguienteJugador();
        assertEquals(turno.jugadorActual().obtenerColor(), "Rojo");
        assertEquals(turno.cantidadDeJugadores(), 4);

        turno.siguienteJugador();
        assertEquals(turno.jugadorActual().obtenerColor(), "Amarillo");
        
        turno.siguienteJugador();
        assertEquals(turno.jugadorActual().obtenerColor(), "Verde");
    }
}
