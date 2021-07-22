package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.Assert.*;

public class PaisFactoryTest {
    @Test
    public void test01PaisSeInicializa() {
        PaisFactory mapa = new PaisFactory();
        mapa.inicializarMapa();

        IPais francia = mapa.obtenerPais("Francia");
        IPais labrador = mapa.obtenerPais("Labrador");

        assertEquals("Francia", francia.obtenerNombre());
        assertEquals("Labrador", labrador.obtenerNombre());
    }

    @Test
    public void test02PaisTieneAdyacentes() {
        PaisFactory mapa = new PaisFactory();
        mapa.inicializarMapa();

        IPais italia = mapa.obtenerPais("Italia");
        List<IPais> adyacentes = italia.obtenerAdyacentes();

        assertTrue(adyacentes.contains(mapa.obtenerPais("Alemania")));
        assertTrue(adyacentes.contains(mapa.obtenerPais("Francia")));
    }

    @Test
    public void test03EncontrarPais() {
        MapaFachada mapa = new MapaFachada();
        List<Pais> paises = mapa.inicializarMapa();

        Pais italia = paises
                .stream()
                .filter(p -> (p.obtenerNombre() == "Italia"))
                .findAny()
                .get();
    }
}
