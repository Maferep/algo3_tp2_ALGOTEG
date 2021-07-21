package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.factories.JuegoFactory;
import edu.fiuba.algo3.modelo.factories.JugadorFactoryMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {
    JuegoFactory juegoBuilder = new JuegoFactory();
    //Juego de una ronda con 2 jugadores. En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test00RondaDeDosJugadoresSinAtaques() throws Exception {
        // fase inicial
        JugadorFactoryMock tipoDeJugador = new JugadorFactoryMock();
        IFase fase = juegoBuilder.crearJuegoTEG(2, tipoDeJugador);
        assertFalse(fase.faseCompletada());

        Pais pais = new Pais("Estados Unidos");
        fase.asFaseInicio().ubicarEjercitosEnPais(3, pais);
        fase.asFaseInicio().ubicarEjercitosEnPais(5, pais);
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
        fase.asFaseColocar().ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 11);
        fase = fase.siguienteFase();

        // comienzo a atacar devuelta
        fase.asFaseAtacar().saltearAtaque();
    }

    //Juego de una ronda con 3 jugadores (el  jugador 2 controla Asia completamente).
    //En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test01RondaDeTresJugadoresSinAtaques() throws Exception {

    }

    //Juego de una ronda con 2 jugadores.
    //En esta ronda el jugador 1 ataca y conquista dos países del jugador 2.

    @Test
    public void test02RondaDosJugadoresConAtaques() throws Exception {

    }

    @Test
    public void test03RondaDeDosJugadoresSinAtaquesNoHaySuficientesFichasParaColocar() throws Exception {
        // fase inicial
        JugadorFactoryMock tipoDeJugador = new JugadorFactoryMock();
        IFase fase = juegoBuilder.crearJuegoTEG(2, tipoDeJugador);
        assertFalse(fase.faseCompletada());

        Pais pais = new Pais("Estados Unidos");
        fase.asFaseInicio().ubicarEjercitosEnPais(3, pais);
        fase.asFaseInicio().ubicarEjercitosEnPais(5, pais);
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

        // fase juego : colocar pero no hay suficientes fichas
        IFase finalFase = fase;
        assertThrows(FichasInsuficientesError.class, () -> {
            finalFase.asFaseColocar().ubicarEjercitosEnPais(100, pais);
        } );
    }
}
