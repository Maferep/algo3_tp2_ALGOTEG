package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.factories.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Mocks.*;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {
    
    JuegoFactory juegoBuilder = new JuegoFactory();
    JugadorFactory tipoDeJugador = new JugadorFactory();
    @Test
    public void test00AgregarJugadores() throws Exception {
        juegoBuilder.crearJuegoTEG(3, tipoDeJugador);
    }

    @Test
    public void test01agregarEjercitos() throws Exception {
        // internamente, asigna paises y objetivos a 4 colores
        IFase fase = juegoBuilder.crearJuegoTEG(4, tipoDeJugador);
        assertFalse(fase.faseCompletada());
        fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("EEUU"));
        fase.asFaseInicio().ubicarEjercitosEnPais(5, new Pais("EEUU"));
        assertTrue(fase.faseCompletada());
    }

    @Test
    public void test02PasarPorEtapasDistintas() throws Exception {
        //genera una etapa de inicio en estado 'finalizado' de ejemplo
        IFase fase = juegoBuilder.crearJuegoTEG(4, tipoDeJugador);
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
    
    //Juego de una ronda con 2 jugadores. 
    //En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test03RondaDeDosJugadoresSinAtaques() throws Exception {
        // fase inicial
        JugadorFactoryMock tipoDeJugador = new JugadorFactoryMock();
        IFase fase = juegoBuilder.crearJuegoTEG(2, tipoDeJugador);
        assertFalse(fase.faseCompletada());
        // aca debo asignar los paises a los jugadores: etapa inicio.
                    fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("Estados Unidos"));
                    fase.asFaseInicio().ubicarEjercitosEnPais(5, new Pais("Estados Unidos"));
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        // fase juego : atacar (sin conquista);
        fase = fase.siguienteFase();

        // fase juego : reagrupar
        fase.asFaseReagrupar().reagrupar();
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        // fase juego : colocar
        Pais pais = new Pais("EEUU");
        fase.asFaseColocar().ubicarEjercitosEnPais(3, pais);
        //TODO probar la excepcion tambien
        assertTrue(fase.faseCompletada());
        //assertEquals(fase.asFaseColocar().turno.jugadorActual().paises.size(), 3);
        //assertEquals(fase.asFaseColocar().turno.jugadorActual().cantidadEjercitos(), 3);

        assertEquals(pais.cantidadEjercitos(), 3);
        fase = fase.siguienteFase();

        // comienzo a atacar devuelta
        fase.asFaseAtacar().atacar(null, 0, null);
    }
}
