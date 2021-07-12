package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueTest {
    @Test
    public void test01AtacarPaisGanaDefensor() throws Exception {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Chile");

        atacante.asignarConquistador(new Jugador("Mafer"));
        defensor.asignarConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,1, 1, 1);
        ataqueFalso.atacar(atacante, defensor,1);

        assertEquals("Cande", defensor.obtenerConquistador().obtenerNombre());
        assertEquals(2, atacante.cantidadEjercitos());
    }

    @Test
    public void test02AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() throws Exception {
        Pais atacante = new Pais("Paraguay");
        Pais defensor = new Pais("Uruguay");

        atacante.asignarConquistador(new Jugador("Martín"));
        defensor.asignarConquistador(new Jugador("Tobías"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor, 2, 1, 1);
        ataqueFalso.atacar(atacante, defensor, 2);

        //Hay que modificar la prueba o revisar el código
        assertEquals("Tobías", defensor.obtenerConquistador().obtenerNombre());
        assertEquals(3, defensor.cantidadEjercitos());
        assertEquals(1, atacante.cantidadEjercitos());
    }

    @Test
    public void test03AtacarPaisGanaAtacante() throws Exception {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Pepe"));
        defensor.asignarConquistador(new Jugador("Daniel"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,2, 6, 1);
        ataqueFalso.atacar(atacante, defensor,2);

        //Prueba no pasada. Revisar código
        //assertEquals("Daniel", defensor.obtenerConquistador().obtenerNombre());
        assertEquals(3, atacante.cantidadEjercitos());
        assertEquals(1, defensor.cantidadEjercitos());
    }

    @Test
    public void test04AtacarPaisGanaAtacanteYDefensorSeQuedaSinEjercitos() throws Exception {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Chiara"));
        defensor.asignarConquistador(new Jugador("Pili"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,3, 6, 1);
        ataqueFalso.atacar(atacante, defensor, 3);

        assertEquals(atacante.obtenerConquistador().obtenerNombre(), defensor.obtenerConquistador().obtenerNombre());
        assertEquals(0, defensor.cantidadEjercitos());
    }

    //prueba para que atacante si o si deba tener mas de una ficha para atacar
    @Test
    public void test05AtacanteDebeTenerMasDeUnaFichaParaAtacar() throws Exception {
        Pais atacante = new Pais("Rusia");
        Pais defensor = new Pais("Noruega");

        atacante.agregarEjercitos(1);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,4, 6, 1);

        assertThrows(Exception.class, () -> ataqueFalso.atacar(atacante, defensor, 4));
    }

    //no puede atacar con 3 fichas teniendo 3 fichas
    @Test
    public void test06AtacanteNoPuedeAtacarConLaMismaCantidadDeFichasQuePosee() throws Exception {
        Pais atacante = new Pais("Rusia");
        Pais defensor = new Pais("Noruega");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,3, 6, 1);;
        assertThrows(Exception.class, () -> ataqueFalso.atacar(atacante, defensor, 3));
    }
}

