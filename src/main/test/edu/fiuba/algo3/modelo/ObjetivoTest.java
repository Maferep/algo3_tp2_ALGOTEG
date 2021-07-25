package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.fases.FaseInicio;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
