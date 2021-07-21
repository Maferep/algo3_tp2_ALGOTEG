package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.factories.JuegoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {
    JuegoFactory juegoBuilder = new JuegoFactory();
    //Juego de una ronda con 2 jugadores. En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test00RondaDeDosJugadoresSinAtaques() throws Exception {
        // fase inicial
        IFase fase = juegoBuilder.crearJuegoTEG(2);
        assertFalse(fase.faseCompletada());
        // aca debo asignar los paises a los jugadores: etapa inicio.
        fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("EEUU"));
        fase.asFaseInicio().ubicarEjercitosEnPais(5, new Pais("EEUU"));
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        // fase juego : atacar
        fase.asFaseAtacar().saltearAtaque();
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        // fase juego : reagrupar
        fase.asFaseReagrupar().reagrupar();
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        // fase juego : colocar
        Pais pais = new Pais("EEUU");
        fase.asFaseColocar().ubicarEjercitosEnPais(3, pais);
        //probar la excepcion tambien
        assertTrue(fase.faseCompletada());
        //assertEquals(fase.asFaseColocar().turno.jugadorActual().paises.size(), 3);
        assertEquals(fase.asFaseColocar().turno.jugadorActual().cantidadEjercitos(), 3);

        //assertEquals(pais.cantidadEjercitos(), 3);
        fase = fase.siguienteFase();

        // comienzo a atacar devuelta
        //fase.asFaseAtacar().atacar(null, 0, null, null);
    }
}
