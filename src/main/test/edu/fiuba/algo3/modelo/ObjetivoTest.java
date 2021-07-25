package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetivoTest {
    @Test
    public void test00SeAsignanObjetivosAJugadores() throws Exception {
        Juego juegoNuevo = new Juego(2);
        assertEquals(juegoNuevo.faseActual.obtenerObjetivo().objetivos.size(), 3);
    }
}
