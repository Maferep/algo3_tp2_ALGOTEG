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
        IFase fase = juegoBuilder.crearJuegoTEG(4);
        assertFalse(fase.faseCompletada());
        // aca debo asignar los paises a los jugadores: etapa inicio.
        fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("EEUU"));
        fase.asFaseInicio().ubicarEjercitosEnPais(5, new Pais("EEUU"));
        assertTrue(fase.faseCompletada());

        fase = fase.siguienteFase();
        // fase juego : atacar
        fase.asFaseAtacar().atacar(null, 0, null);
        assertTrue(fase.faseCompletada());

        fase = fase.siguienteFase(); //fase es null, cambiar eso.
        // fase juego : reagrupar
        fase.asFaseReagrupar().reagrupar();
        // fase juego : colocarEjercitos
       // fase.asFaseColocar().ubicarEjercitosEnPais(5, new Pais("EEUU"));
    }
}
