package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Mocks.TurnoMock;
import edu.fiuba.algo3.modelo.fases.FaseAtacar;
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
        assertFalse(juegoNuevo.faseActual.esFinDeJuego());
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

    @Test
    public void test03AtacarSinCumplirObjetivo() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        Jugador jugador = new Jugador("Rosa");
        jugador.asignarObjetivo(new ObjetivoGeneral());

        atacante.definirConquistador(jugador);
        defensor.definirConquistador(new Jugador("Amarillo"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        ITurno turno = new TurnoMock();
        FaseAtacar fase = new FaseAtacar(turno, null);

        fase.atacar(atacante, 1, defensor);
        assertEquals(fase.esFinDeJuego(), false);
    }

    @Test
    public void test03AtacarYCumplirObjetivo() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        Jugador jugador = new Jugador("Rosa");
        jugador.asignarObjetivo(new ObjetivoGeneral());

        atacante.definirConquistador(jugador);
        defensor.definirConquistador(new Jugador("Amarillo"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        ITurno turno = new TurnoMock();
        FaseAtacar fase = new FaseAtacar(turno, null);

        fase.atacar(atacante, 1, defensor);
        assertEquals(fase.esFinDeJuego(), false);

        for(int i = 0 ; i < 30 ; i++) {
            atacante.obtenerConquistador().asignarPais(new Pais("EEUU"));
        }
        assertEquals(atacante.obtenerConquistador().obtenerPaises().size(), 31);
        assertEquals(atacante.obtenerConquistador().seCumplioObjetivo(), true);
        fase.atacar(atacante, 1, defensor);
        assertEquals(fase.esFinDeJuego(), true);
    }

}
