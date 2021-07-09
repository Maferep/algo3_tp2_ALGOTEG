package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaisTest {
    @Test
    public void test01NombrarPais() {
        Pais pais = new Pais("Estados Unidos");
        assertEquals("Estados Unidos", pais.obtenerNombre());
    }
    @Test
    public void test02AtacarPais() {
        Pais atacante = new Pais("Estados Unidos");
        Pais defensor = new Pais("Canada");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Boolean conquisto = atacante.atacar(defensor, 1);
        assertEquals(false, conquisto);
    }
    @Test
    public void test03AtacarPaisGanaDefensor() {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Chile");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Boolean conquisto = atacante.atacar(defensor, 1);
        assertEquals(false, conquisto);
        assertEquals(2, atacante.cantidadEjercitos());
    }
    @Test
    public void test04AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() {
        Pais atacante = new Pais("Paraguay");
        Pais defensor = new Pais("Uruguay");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Boolean conquisto = atacante.atacar(defensor, 3);
        assertEquals(false, conquisto);
        assertEquals(1, atacante.cantidadEjercitos());
    }
}