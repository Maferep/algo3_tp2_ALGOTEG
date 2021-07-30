package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjetasTest {
    IPais pais = new PaisMock("Pais mockito");
    Simbolo globo = new Simbolo("globo");
    Simbolo maquina = new Simbolo("maquina");
    Simbolo lampara = new Simbolo("lampara");

    @Test
    public void test01TarjetasSonIguales() {
        Tarjeta tarjetaArgentina = new Tarjeta(pais, globo);
        Tarjeta tarjetaColombia = new Tarjeta(pais, globo);
        Tarjeta tarjetaChile = new Tarjeta(pais, globo);

        List<Tarjeta> tarjetasPaises = Arrays.asList(tarjetaArgentina, tarjetaChile, tarjetaColombia);

        Tarjetas tarjetas = new Tarjetas(tarjetasPaises);

        Assert.assertTrue(tarjetas.sonValidas());
    }

    @Test
    public void test02TresTarjetasDistintas() {
        Tarjeta tarjetaArgentina = new Tarjeta(pais, globo);
        Tarjeta tarjetaColombia = new Tarjeta(pais, maquina);
        Tarjeta tarjetaChile = new Tarjeta(pais, lampara);

        List<Tarjeta> tarjetasPaises = Arrays.asList(tarjetaArgentina, tarjetaChile, tarjetaColombia);

        Tarjetas tarjetas = new Tarjetas(tarjetasPaises);

        Assert.assertTrue(tarjetas.sonValidas());
    }

    @Test public void test03DosTarjetasIgualesUnaDistinta() {
        Tarjeta tarjetaArgentina = new Tarjeta(pais, globo);
        Tarjeta tarjetaColombia = new Tarjeta(pais, maquina);
        Tarjeta tarjetaChile = new Tarjeta(pais, globo);

        List<Tarjeta> tarjetasPaises = Arrays.asList(tarjetaArgentina, tarjetaChile, tarjetaColombia);

        Tarjetas tarjetas = new Tarjetas(tarjetasPaises);

        Assert.assertFalse(tarjetas.sonValidas());
    }
}
