package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MapaFachadaTest {
    @Test
    public void test01PaisSeInicializa() {
        MapaFachada mapa = new MapaFachada();
        mapa.inicializarMapa();

        Pais francia = mapa.obtenerPais("Francia");
        Pais labrador = mapa.obtenerPais("Labrador");

        assertEquals("Francia", francia.obtenerNombre());
        assertEquals("Labrador", labrador.obtenerNombre());
    }

    @Test
    public void test02PaisTieneAdyacentes() {
        MapaFachada mapa = new MapaFachada();
        mapa.inicializarMapa();

        Pais italia = mapa.obtenerPais("Italia");
        List<Pais> adyacentes = italia.obtenerAdyacentes();

        assertTrue(adyacentes.contains(mapa.obtenerPais("Alemania")));
        assertTrue(adyacentes.contains(mapa.obtenerPais("Francia")));
    }

    @Test
    public void test03PaisTieneAdyacentes() {
        MapaFachada mapa = new MapaFachada();
        List<Pais> paises = mapa.inicializarMapa();
        assertFalse(paises.isEmpty());

        //codigo rompe porque no hay un pais con este nombre
        Pais italia = paises
            .stream()
            .filter(p -> (p.obtenerNombre() == "Italia"))
            .findAny()
            .get();
    }

}
