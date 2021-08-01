package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtaqueTest {
    @Test
    public void test01AtacarPaisGanaDefensor() throws Exception {
        IPais atacante = new Pais("Argentina");
        IPais defensor = new Pais("Chile");

        atacante.definirConquistador(new Jugador("Azul"));
        defensor.definirConquistador(new Jugador("Rojo"));

        int cantidadEjercitos = 3;

        atacante.agregarEjercitos(cantidadEjercitos);
        defensor.agregarEjercitos(cantidadEjercitos);

        int cantidadVictorias = 1;
        int cantidadDerrotas = 1;

        IDado dadoMock = new DadosUsadosMock(cantidadVictorias, cantidadDerrotas);

        Ataque ataque = new Ataque(atacante, defensor, dadoMock);
        ataque.atacar();

        assertEquals("Rojo", defensor.obtenerConquistador().obtenerColor());
        assertEquals(2, atacante.cantidadEjercitos());
    }

    @Test
    public void test02AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() throws Exception {
        IPais atacante = new Pais("Paraguay");
        IPais defensor = new Pais("Uruguay");

        atacante.definirConquistador(new Jugador("Rojo"));
        defensor.definirConquistador(new Jugador("Azul"));

        int cantidadEjercitos = 3;

        atacante.agregarEjercitos(cantidadEjercitos);
        defensor.agregarEjercitos(cantidadEjercitos);

        int cantidadVictorias = 0;
        int cantidadDerrotas = 2;

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(cantidadVictorias, cantidadDerrotas));
        ataqueFalso.atacar();

        assertEquals(1, atacante.cantidadEjercitos());
        assertEquals(3, defensor.cantidadEjercitos());

        assertEquals("Azul", defensor.obtenerConquistador().obtenerColor());
        assertEquals(3, defensor.cantidadEjercitos());
        assertEquals(1, atacante.cantidadEjercitos());
    }

    @Test
    public void test03AtacarPaisGanaAtacante() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.definirConquistador(new Jugador("Rojo"));
        defensor.definirConquistador(new Jugador("Azul"));

        int cantidadEjercitos = 3;

        atacante.agregarEjercitos(cantidadEjercitos);
        defensor.agregarEjercitos(cantidadEjercitos);

        int cantidadVictorias = 1;
        int cantidadDerrotas = 1;

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(cantidadVictorias, cantidadDerrotas));
        ataqueFalso.atacar();

        assertEquals("Azul", defensor.obtenerConquistador().obtenerColor());
        assertEquals(2, atacante.cantidadEjercitos());
        assertEquals(2, defensor.cantidadEjercitos());
    }

    @Test
    public void test04AtacarPaisGanaAtacanteYDefensorSeQuedaSinEjercitos() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.definirConquistador(new Jugador("Azul"));
        defensor.definirConquistador(new Jugador("Rojo"));

        int cantidadEjercitosAzul = 4;
        int cantidadEjercitosRojo = 3;

        atacante.agregarEjercitos(cantidadEjercitosAzul);
        defensor.agregarEjercitos(cantidadEjercitosRojo);

        int cantidadVictorias = 3;
        int cantidadDerrotas = 0;

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(cantidadVictorias, cantidadDerrotas));
        ataqueFalso.atacar();

        assertEquals(atacante.obtenerConquistador().obtenerColor(), defensor.obtenerConquistador().obtenerColor());
        assertEquals(0, defensor.cantidadEjercitos());
    }

    @Test
    public void test05AtacanteTrataDeAtacarConTodosSusEjercitos() throws Exception {
        IPais atacante = new Pais("Argentina");
        IPais defensor = new Pais("Chile");

        atacante.definirConquistador(new Jugador("Rojo"));
        defensor.definirConquistador(new Jugador("Azul"));

        int cantidadEjercitos = 3;

        atacante.agregarEjercitos(cantidadEjercitos);
        defensor.agregarEjercitos(cantidadEjercitos);

        assertThrows(FichasInsuficientesException.class, () -> {
                Ataque ataque = new Ataque(atacante, defensor, 3);
                ataque.atacar();
        } );
    }

    @Test
    public void test06AtacanteUsa4EjercitosTiraError() throws Exception {
        IPais atacante = new Pais("Argentina");
        IPais defensor = new Pais("Chile");

        atacante.definirConquistador(new Jugador("Azul"));
        defensor.definirConquistador(new Jugador("Rojo"));

        int cantidadEjercitos = 10;

        atacante.agregarEjercitos(cantidadEjercitos);
        defensor.agregarEjercitos(cantidadEjercitos);

        assertTrue(atacante.cantidadEjercitos() > 4);
        assertThrows(FichasInsuficientesException.class, () -> {
                Ataque ataque = new Ataque(atacante, defensor, 4);
                ataque.atacar();
        } );
    }

}

