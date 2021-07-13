package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IJuegoTest {
    @Test
    public void test00AgregarJugadores() throws Exception {
        String[] jugadores = { "Pablo", "Mohammed", "Alexis" };
        IAltego IAltego = new Juego(jugadores);
        assertEquals(IAltego.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01Agregar4Jugadores() {
        String[] jugadores = { };
        assertThrows(Exception.class, () -> new Juego(jugadores) );
    }

    @Test
    public void test02ColocarEjercitos() throws Exception {
        String[] jugadores = { "Pablo", "Mohammed", "Alexis" };
        IAltego IAltego = new Juego(jugadores);
        IAltego.agregarEjercitosAlJugador("Pablo", 3);

        assertThrows(Exception.class, () -> 
            IAltego.colocarEjercitos("Pablo", 3, "Colombia"));
        IAltego.asignarPaisAJugador("Pablo", "Colombia");
        assertDoesNotThrow(() -> 
            IAltego.colocarEjercitos("Pablo", 3, "Colombia"));

        assertEquals(IAltego.cantidadEjercitosDe("Pablo"), 3);
    }

    @Test
    public void test03AsignarPaisesAJugadores() throws Exception {
        String[] jugadores = { "Pedro", "Mohammed", "Alexis" };
        IAltego IAltego = new Juego(jugadores);
        IAltego.asignarPaisesAleatoriamente();
        assertTrue(IAltego.paisesDe("Pedro").size() > 0);

        //repartir paises entre los jugadores es una particion
        List<String> paisesDeJugadores = Arrays.asList(jugadores)
            .stream()
            .flatMap( j -> IAltego.paisesDe(j).stream())
            .collect(Collectors.toList());
        assertEquals(IAltego.obtenerPaises().size(), paisesDeJugadores.size());
        assertEquals(new HashSet<>(IAltego.obtenerPaises()), new HashSet<>(paisesDeJugadores));
    }

    @Test
    public void test04AgregarVariosSoldados() throws Exception {
        String[] jugadores = {"Pablo", "Avneet", "Sasha", "Sam"};
        IAltego IAltego = new Juego(jugadores);
        IAltego.agregarEjercitosAlJugador("Pablo", 3);
        assertEquals(IAltego.cantidadEjercitosDe("Pablo"), 3);
        IAltego.agregarEjercitosAlJugador("Pablo", 4);
        assertEquals(IAltego.cantidadEjercitosDe("Pablo"), 7);
    }

    @Test
    public void test05AtaqueDeUnPaisAOtro() throws Exception {
        String[] jugadores = {"Pablo", "Mohammed"};
        IAltego altego = new Juego(jugadores);
        altego.asignarPaisAJugador("Pablo", "Colombia");
        altego.asignarPaisAJugador("Mohammed", "Venezuela");

        altego.agregarEjercitosAlJugador("Pablo", 10);
        altego.agregarEjercitosAlJugador("Mohammed", 10);

        altego.agregarEjercitosAlPais("Colombia", 6);
        altego.agregarEjercitosAlPais("Venezuela", 1);

        altego.realizarAtaque("Colombia", 3, "Venezuela");
    }
}