package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ObjetivoTest {
    @Test
    public void test00SeAsignanObjetivosEnLaFaseDeInicio() throws Exception {
        Juego juegoNuevo = new Juego(2);
        assertFalse(juegoNuevo.faseActual.faseCompletada());
        assertEquals(juegoNuevo.faseActual.obtenerObjetivo().objetivos.size(), 6);
    }
}
