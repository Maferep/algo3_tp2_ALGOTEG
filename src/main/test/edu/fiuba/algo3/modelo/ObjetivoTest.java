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

    @Test
    public void test01JugadorCumpleObjetivoGeneral() throws Exception {
        Juego juegoNuevo = new Juego(2);
        Pais pais = new Pais("EEUU");
        for(int i = 0 ; i < 30 ; i++) {
            juegoNuevo.faseActual.turno().jugadorActual().asignarPais(pais);
        }
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerColor(), "Azul");
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerPaises().size(), 34);
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().cumplioObjetivo(), true);
    }

    @Test
    public void test02JugadorNoCumpleObjetivoDeConquistarPaisesYContinentes() throws Exception {
        Juego juegoNuevo = new Juego(2);
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerColor(), "Azul");
        juegoNuevo.faseActual.turno().siguienteJugador();
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerColor(), "Rojo");
        assertFalse(juegoNuevo.faseActual.turno().jugadorActual().cumplioObjetivo());
    }

    @Test
    public void test02JugadorNoCumpleObjetivoDeDestruirAUnEjercitoEspecifico() throws Exception {
        Juego juegoNuevo = new Juego(3);
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerColor(), "Azul");
        juegoNuevo.faseActual.turno().siguienteJugador();
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerColor(), "Rojo");
        juegoNuevo.faseActual.turno().siguienteJugador();
        assertEquals(juegoNuevo.faseActual.turno().jugadorActual().obtenerColor(), "Amarillo");
        assertFalse(juegoNuevo.faseActual.turno().jugadorActual().cumplioObjetivo());
    }

}
