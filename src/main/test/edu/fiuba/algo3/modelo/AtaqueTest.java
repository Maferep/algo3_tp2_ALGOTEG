package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtaqueTest {
    @Test
    public void test01AtacarPaisGanaDefensor() {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Chile");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Boolean conquisto = atacante.atacar(defensor, 1);
        assertEquals(false, conquisto);
        assertEquals(2, atacante.cantidadEjercitos());
    }
    @Test
    public void test02AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() {
        Pais atacante = new Pais("Paraguay");
        Pais defensor = new Pais("Uruguay");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Boolean conquisto = atacante.atacar(defensor, 3);
        assertEquals(false, conquisto);
        assertEquals(1, atacante.cantidadEjercitos());
    }
}

