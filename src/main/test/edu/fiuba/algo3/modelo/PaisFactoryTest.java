package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PaisFactoryTest {
    @Test
    public void test01PaisSeInicializa() {
        PaisFactory mapa = new PaisFactory();
        mapa.inicializarMapa();

        Pais francia = mapa.obtenerPais("Francia");
        Pais labrador = mapa.obtenerPais("Labrador");

        assertEquals("Francia", francia.obtenerNombre());
        assertEquals("Labrador", labrador.obtenerNombre());
    }

    @Test
    public void test02PaisTieneAdyacentes() {
        PaisFactory mapa = new PaisFactory();
        mapa.inicializarMapa();

        Pais italia = mapa.obtenerPais("Italia");
        List<Pais> adyacentes = italia.obtenerAdyacentes();

        assertTrue(adyacentes.contains(mapa.obtenerPais("Alemania")));
        assertTrue(adyacentes.contains(mapa.obtenerPais("Francia")));
    }
}
