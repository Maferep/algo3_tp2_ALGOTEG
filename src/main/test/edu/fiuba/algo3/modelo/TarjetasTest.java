package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjetasTest {

    @Test
    public void test01TarjetasSonIguales() {
        IPais pais = new PaisMock("Pais mockito");
        Simbolo globo = new Simbolo("globo");

        Tarjeta tarjetaArgentina = new Tarjeta(pais, globo);
        Tarjeta tarjetaColombia = new Tarjeta(pais, globo);
        Tarjeta tarjetaChile = new Tarjeta(pais, globo);

        List<Tarjeta> tarjetasPaises = Arrays.asList(tarjetaArgentina, tarjetaChile, tarjetaColombia);

        Tarjetas tarjetas = new Tarjetas(tarjetasPaises);

        Assert.assertTrue(tarjetas.sonValidas());
    }
}
