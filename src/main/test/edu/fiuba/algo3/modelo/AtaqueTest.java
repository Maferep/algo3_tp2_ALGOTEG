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

        atacante.asignarConquistador(new Jugador("Mafer"));
        defensor.asignarConquistador(new Jugador("Cande"));

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

        atacante.asignarConquistador(new Jugador("Martín"));
        defensor.asignarConquistador(new Jugador("Tobías"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(0, 2));
        ataqueFalso.atacar();

        assertEquals(1, atacante.ejercitos);
        assertEquals(3, defensor.ejercitos);

        assertEquals("Tobías", defensor.obtenerConquistador().obtenerColor());
        assertEquals(3, defensor.cantidadEjercitos());
        assertEquals(1, atacante.cantidadEjercitos());
    }

    @Test
    public void test03AtacarPaisGanaAtacante() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Pepe"));
        defensor.asignarConquistador(new Jugador("Daniel"));

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

        atacante.asignarConquistador(new Jugador("Chiara"));
        defensor.asignarConquistador(new Jugador("Pili"));

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

        atacante.asignarConquistador(new Jugador("Mafer"));
        defensor.asignarConquistador(new Jugador("Cande"));

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

        atacante.asignarConquistador(new Jugador("Mafer"));
        defensor.asignarConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(10);
        defensor.agregarEjercitos(10);

        assertTrue(atacante.ejercitos > 4);
        assertThrows(FichasInsuficientesError.class, () -> {
                Ataque ataque = new Ataque(atacante, defensor, 4);
                ataque.atacar();
        } );
    }

}

