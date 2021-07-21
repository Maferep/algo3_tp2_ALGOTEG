package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void test01InicializarMapa() {
        Mapa mapa = new Mapa();
        List<Pais> paises = mapa.obtenerPaises();

        // faltan paises en json, debería haber 55
        assertEquals(50, paises.size());
    }

}
