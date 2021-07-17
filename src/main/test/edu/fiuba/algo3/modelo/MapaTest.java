package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MapaTest {
    @Test
    public void test01InicializarMapa() {
        Mapa mapa = new Mapa();
        assertEquals(mapa.cantidadPaises(), 55);
    }
}
