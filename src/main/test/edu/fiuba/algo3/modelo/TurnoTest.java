package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    @Test
    public void test00JugadorConTurnoCorrecto() throws Exception {
        Turno turno = new Turno(4);
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
