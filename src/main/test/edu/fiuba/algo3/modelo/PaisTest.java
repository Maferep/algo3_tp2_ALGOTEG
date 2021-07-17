package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.modelo.Interfaces.*;


public class PaisTest {
    @Test
    public void test01NombrarPais() {
        Pais pais = new Pais("Estados Unidos");
        assertEquals("Estados Unidos", pais.obtenerNombre());
    }
    @Test
    public void test02AtacarPais() throws Exception {
        Pais atacante = new Pais("Estados Unidos");
        Pais defensor = new Pais("Canada");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);
        IAtaque ataqueFalso = new AtaqueMock(atacante, defensor);
        atacante.atacar(ataqueFalso);
        assertEquals(atacante.obtenerConquistador(), defensor.obtenerConquistador());
    }
}