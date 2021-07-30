package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.INumeroDeCanje;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanjeTest {
    Simbolo globo = new Simbolo("globo");
    Simbolo maquina = new Simbolo("maquina");
    Simbolo lampara = new Simbolo("lampara");

    IPais argentina = new Pais("Argentina");
    IPais colombia = new Pais("Colombia");
    IPais chile = new Pais("Chile");

    @Test
    public void test01RealizarCanjeTresSimbolosIguales() 
            throws NoSePuedeProducirCanjeException, 
                EjercitosException {
        
        Tarjeta tarjetaArgentina = new Tarjeta(argentina, globo);
        Tarjeta tarjetaColombia = new Tarjeta(colombia, globo);
        Tarjeta tarjetaChile = new Tarjeta(chile, globo);

        List<Tarjeta> tarjetas = Arrays.asList(
            tarjetaArgentina, tarjetaChile, tarjetaColombia);

        Canje canje = new Canje();
        int ejercitosObtenidos = canje.realizarCanje(tarjetas);

        Assert.assertEquals(4, ejercitosObtenidos);
    }

    @Test
    public void test02RealizarCanjeTresSimbolosDistintos() throws NoSePuedeProducirCanjeException, EjercitosException {
        Tarjeta tarjetaArgentina = new Tarjeta(argentina, globo);
        Tarjeta tarjetaColombia = new Tarjeta(colombia, maquina);
        Tarjeta tarjetaChile = new Tarjeta(chile, lampara);

        List<Tarjeta> tarjetas = Arrays.asList(tarjetaArgentina, tarjetaChile, tarjetaColombia);

        Canje canje = new Canje();
        int cantidadEjercitos = canje.realizarCanje(tarjetas);

        Assert.assertEquals(4, cantidadEjercitos);
    }
}
