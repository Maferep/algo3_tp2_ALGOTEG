package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConquistaTest {

    @Test
    public void test00JugadorConquistaPais() {
        Jugador jugador = new Jugador("Valen");
        Pais argentina = new Pais("Argentina");
        Conquista conquista = new Conquista();

        conquista.conquistar(jugador, argentina);

        assertEquals(argentina.obtenerConquistador().obtenerColor(), "Valen");
    }
}
