package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetivoTest {
    @Test
    public void test00JugadorCumpleObjetivoGeneral() {
        List<Jugador> jugadores = Arrays.asList(
                new Jugador("Azul"),
                new Jugador("Rojo"),
                new Jugador("Amarillo"),
                new Jugador("Verde"));
        Jugador jugador = jugadores.get(0);
        Pais pais = new Pais("EEUU");
        for(int i = 0 ; i < 30 ; i++) {
            jugador.asignarPais(pais);
        }
        Turno turno = new Turno(jugadores);
        assertEquals(turno.jugadorActual().obtenerColor(), "Azul");
        assertEquals(turno.jugadorActual().paises.size(), 30);
        assertEquals(turno.jugadorActual().cumpleObjetivoGeneral(), true);
    }

    @Test
    public void test01JugadorCumpleObjetivoDeDestruirAlEjercitoEspecifico() throws Exception {
        List<Jugador> jugadores = Arrays.asList(
                new Jugador("Azul"),
                new Jugador("Rojo"),
                new Jugador("Amarillo"),
                new Jugador("Verde"));

        List<Pais> paises = Arrays.asList(
                new Pais("España"),
                new Pais("Francia"));

        Jugador jugador = jugadores.get(0);
        Jugador jugadorADestruir = jugadores.get(1);

        Pais atacante = paises.get(0);
        Pais defensor = paises.get(1);

        atacante.asignarConquistador(jugador);
        defensor.asignarConquistador(jugadorADestruir);

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(3,0));
        ataqueFalso.atacar();

        Turno turno = new Turno(jugadores);
        assertEquals(turno.jugadorActual().obtenerColor(), "Azul");
        assertEquals(turno.jugadorActual().cumpleObjetivoDeDestruirAUnEjercitoEspecifico(jugadorADestruir, paises), true);
    }
}
