package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IJuegoTest {
    @Test
    public void test00AgregarJugadores() throws Exception {
        String[] jugadores = { "Pablo", "Mohammed", "Alexis" };
        IAltego juego = new Juego(jugadores);
        assertEquals(juego.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01Agregar4Jugadores() {
        String[] jugadores = { };
        assertThrows(Exception.class, () -> new Juego(jugadores) );
    }

    @Test
    public void test02ColocarEjercitos() throws Exception {
        String[] jugadores = { "Pablo", "Mohammed", "Alexis" };
        IAltego juego = new Juego(jugadores);
        juego.agregarEjercitosAlJugador("Pablo", 3);

        assertThrows(Exception.class, () -> 
            juego.colocarEjercitos("Pablo", 3, "Colombia"));
        juego.asignarPaisAJugador("Pablo", "Colombia");
        assertDoesNotThrow(() -> 
            juego.colocarEjercitos("Pablo", 3, "Colombia"));

        assertEquals(juego.cantidadEjercitosDe("Pablo"), 3);
    }

    @Test
    public void test03AsignarPaisesAJugadores() throws Exception {
        String[] jugadores = { "Pedro", "Mohammed", "Alexis" };
        IAltego juego = new Juego(jugadores);
        juego.asignarPaisesAleatoriamente();
        assertTrue(juego.paisesDe("Pedro").size() > 0);

        //repartir paises entre los jugadores es una particion
        List<String> paisesDeJugadores = Arrays.asList(jugadores)
            .stream()
            .flatMap( j -> juego.paisesDe(j).stream())
            .collect(Collectors.toList());
        assertEquals(juego.obtenerPaises().size(), paisesDeJugadores.size());
        assertEquals(new HashSet<>(juego.obtenerPaises()), new HashSet<>(paisesDeJugadores));
    }

    @Test
    public void test04AgregarVariosSoldados() throws Exception {
        String[] jugadores = {"Pablo", "Avneet", "Sasha", "Sam"};
        IAltego juego = new Juego(jugadores);
        juego.agregarEjercitosAlJugador("Pablo", 3);
        assertEquals(juego.cantidadEjercitosDe("Pablo"), 3);
        juego.agregarEjercitosAlJugador("Pablo", 4);
        assertEquals(juego.cantidadEjercitosDe("Pablo"), 7);
    }

    @Test
    public void test05AtaqueDeUnPaisAOtro() throws Exception {
        String[] jugadores = {"Pablo", "Mohammed"};
        IAltego juego = new Juego(jugadores);
        juego.asignarPaisAJugador("Pablo", "Colombia");
        juego.asignarPaisAJugador("Mohammed", "Venezuela");

        juego.agregarEjercitosAlJugador("Pablo", 10);
        juego.agregarEjercitosAlJugador("Mohammed", 10);

        juego.agregarEjercitosAlPais("Colombia", 6);
        juego.agregarEjercitosAlPais("Venezuela", 1);

        juego.realizarAtaque("Colombia", 3, "Venezuela");
    }
}