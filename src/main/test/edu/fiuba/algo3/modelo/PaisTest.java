package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mocks.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.modelo.Interfaces.*;


public class PaisTest {
    @Test
    public void test01NombrarPais() {
        IPais pais = new Pais("Estados Unidos");
        assertEquals("Estados Unidos", pais.obtenerNombre());
    }
    @Test
    public void test02AtacarPais() throws Exception {
        IPais atacante = new Pais("Estados Unidos");
        IPais defensor = new Pais("Canada");

        int cantidadEjercitos = 3;

        atacante.agregarEjercitos(cantidadEjercitos);
        defensor.agregarEjercitos(cantidadEjercitos);

        IAtaque ataqueFalso = new AtaqueMock(atacante, defensor);

        atacante.atacar(ataqueFalso);
        assertEquals(atacante.obtenerConquistador(), defensor.obtenerConquistador());
    }
}