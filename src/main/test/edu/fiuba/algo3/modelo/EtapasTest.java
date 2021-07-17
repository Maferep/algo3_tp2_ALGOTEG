package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.builders.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EtapasTest {
    IJuegoBuilder juegoBuilder = new JuegoBuilder();

    @Test
    public void test00AgregarJugadores() throws Exception {
        juegoBuilder.crearJuegoTEG(3);
    }

    @Test
    public void test01agregarEjercitos() throws Exception {
        // internamente, asigna paises y objetivos a 4 colores
        IFase fase = juegoBuilder.crearJuegoTEG(4);
        assertFalse(fase.faseCompletada());
        fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("EEUU"));
        fase.asFaseInicio().ubicarEjercitosEnPais(5, new Pais("EEUU"));
        assertTrue(fase.faseCompletada());
    }

    @Test
    public void test02PasarPorEtapasDistintas() throws Exception {
        //genera una etapa de inicio en estado 'finalizado' de ejemplo
        IFase fase = juegoBuilder.crearJuegoTEG(4);
        assertFalse(fase.faseCompletada());

        fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("Francia"));
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        fase.asFaseAtacar().atacar(null, 0, null);
        assertTrue(fase.faseCompletada());
    }
}