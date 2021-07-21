package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.factories.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EtapasTest {
    JuegoFactory juegoBuilder = new JuegoFactory();

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

        Pais pais = new Pais("Francia");
        pais.agregarEjercitos(3);
        Pais pais2 = new Pais("Alemania");
        pais2.agregarEjercitos(3);

        fase.asFaseInicio().ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        fase.asFaseAtacar().atacar(pais, 1, pais2);
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();
    }
}