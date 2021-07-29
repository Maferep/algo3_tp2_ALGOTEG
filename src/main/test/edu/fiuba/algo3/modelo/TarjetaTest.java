package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TarjetaTest {

    @Test
    public void test01ActivarTarjeta() {
        IPais argentina = new Pais("Argentina");
        Simbolo simbolo = new Simbolo("Globo");
        Tarjeta tarjeta = new Tarjeta(argentina, simbolo);

        tarjeta.activar();

        Assert.assertEquals(2, argentina.cantidadEjercitos());
    }

    @Test
    public void test02NoActivarTarjetaNoModificaPais() {
        IPais argentina = new Pais("Argentina");
        Simbolo simbolo = new Simbolo("Globo");
        Tarjeta tarjeta = new Tarjeta(argentina, simbolo);


    }
}
