package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetivoTest {
    @Test
    public void test00JugadorCumpleObjetivoGeneral() {
        List<Jugador> jugadores = Arrays.asList(
                new Jugador("Azul"),
                new Jugador("Rojo"),
                new Jugador("Amarillo"),
                new Jugador("Verde"));
        Jugador jugador = jugadores.get(0);
        Pais pais = new Pais("EEUU");
        for(int i = 0 ; i < 30 ; i++) {
            jugador.asignarPais(pais);
        }
        Turno turno = new Turno(jugadores);
        assertEquals(turno.jugadorActual().obtenerColor(), "Azul");
        assertEquals(turno.jugadorActual().paises.size(), 30);
        assertEquals(turno.jugadorActual().cumpleObjetivoGeneral(), true);
    }
}
