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

        atacante.definirConquistador(new Jugador("Mafer"));
        defensor.definirConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(1,1));
        ataqueFalso.atacar();

        assertEquals("Cande", defensor.obtenerConquistador().obtenerColor());
        assertEquals(2, atacante.cantidadEjercitos());
    }

    @Test
    public void test02AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() throws Exception {
        IPais atacante = new Pais("Paraguay");
        IPais defensor = new Pais("Uruguay");

        atacante.definirConquistador(new Jugador("Martín"));
        defensor.definirConquistador(new Jugador("Tobías"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(0, 2));
        ataqueFalso.atacar();

        assertEquals(1, atacante.cantidadEjercitos());
        assertEquals(3, defensor.cantidadEjercitos());

        assertEquals("Tobías", defensor.obtenerConquistador().obtenerColor());
        assertEquals(3, defensor.cantidadEjercitos());
        assertEquals(1, atacante.cantidadEjercitos());
    }

    @Test
    public void test03AtacarPaisGanaAtacante() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.definirConquistador(new Jugador("Pepe"));
        defensor.definirConquistador(new Jugador("Daniel"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);
        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(1,1));
        ataqueFalso.atacar();

        assertEquals("Daniel", defensor.obtenerConquistador().obtenerColor());
        assertEquals(2, atacante.cantidadEjercitos());
        assertEquals(2, defensor.cantidadEjercitos());
    }

    @Test
    public void test04AtacarPaisGanaAtacanteYDefensorSeQuedaSinEjercitos() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.definirConquistador(new Jugador("Chiara"));
        defensor.definirConquistador(new Jugador("Pili"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(3,0));
        ataqueFalso.atacar();

        assertEquals(atacante.obtenerConquistador().obtenerColor(), defensor.obtenerConquistador().obtenerColor());
        assertEquals(0, defensor.cantidadEjercitos());
    }

    @Test
    public void test05AtacanteTrataDeAtacarConTodosSusEjercitos() throws Exception {
        IPais atacante = new Pais("Argentina");
        IPais defensor = new Pais("Chile");

        atacante.definirConquistador(new Jugador("Mafer"));
        defensor.definirConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        assertThrows(FichasInsuficientesError.class, () -> {
                Ataque ataque = new Ataque(atacante, defensor, 3);
                ataque.atacar();
        } );
    }

    @Test
    public void test06AtacanteUsa4EjercitosTiraError() throws Exception {
        IPais atacante = new Pais("Argentina");
        IPais defensor = new Pais("Chile");

        atacante.definirConquistador(new Jugador("Mafer"));
        defensor.definirConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(10);
        defensor.agregarEjercitos(10);

        assertTrue(atacante.cantidadEjercitos() > 4);
        assertThrows(FichasInsuficientesError.class, () -> {
                Ataque ataque = new Ataque(atacante, defensor, 4);
                ataque.atacar();
        } );
    }

}

