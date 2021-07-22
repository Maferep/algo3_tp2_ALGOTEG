package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Interfaces.IPais;

import static org.junit.jupiter.api.Assertions.*;

public class ConquistaTest {

    @Test
    public void test00JugadorConquistaPais() {
        Jugador jugador = new Jugador("Rosa");
        IPais argentina = new Pais("Argentina");

        argentina.definirConquistador(jugador);

        assertEquals(argentina.obtenerConquistador().obtenerColor(), "Rosa");
    }
}
