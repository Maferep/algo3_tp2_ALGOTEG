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
    public void test02AtacarPais() throws Exception {
        Pais atacante = new Pais("Estados Unidos");
        Pais defensor = new Pais("Canada");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);
        Ataque ataqueFalso = new Ataque(atacante, defensor,new DadoFalso(3,0));
        atacante.atacar(defensor, 1, ataqueFalso);
        assertEquals(atacante.obtenerConquistador(), defensor.obtenerConquistador());
    }
}