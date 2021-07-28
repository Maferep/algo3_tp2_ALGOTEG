package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapaFachadaTest {

    @Test
    public void test00CantidadDePaisesCorrecta() {
        MapaFachada mapa = new MapaFachada();
        List<IPais> paises = mapa.obtenerPaises();

        Assert.assertEquals(50, paises.size());
    }

    @Test
    public void test01PaisItaliaFueCreado() {
        MapaFachada mapa = new MapaFachada();
        List<IPais> paises = mapa.obtenerPaises();

        IPais italia = paises
                .stream()
                .filter(p -> (p.obtenerNombre().equals("Italia")))
                .findAny()
                .get();

        Assert.assertEquals("Italia", italia.obtenerNombre());
    }

    @Test
    public void test02PaisItaliaTieneAdyacentes() {
        MapaFachada mapa = new MapaFachada();
        List<IPais> paises = mapa.obtenerPaises();

        IPais italia = paises
                .stream()
                .filter(p -> (p.obtenerNombre().equals("Italia")))
                .findAny()
                .get();


        IPais alemania = paises
                .stream()
                .filter(p -> (p.obtenerNombre().equals("Alemania")))
                .findAny()
                .get();

        IPais francia = paises
                .stream()
                .filter(p -> (p.obtenerNombre().equals("Francia")))
                .findAny()
                .get();

        //es adyacente a estos paises...
        Assert.assertTrue(italia.esAdyacenteA(alemania));
        Assert.assertTrue(italia.esAdyacenteA(francia));

        //pero no a cualquier pais.
        Assert.assertFalse(italia.esAdyacenteA(new Pais("Argentina")));
    }
}
