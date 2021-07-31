package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {
    Mazo mazo = new Mazo(new ArrayList<IPais>());

    IPais argentina = new Pais("Argentina");

    Simbolo globo = new Simbolo("Globlo");
    Simbolo lampara = new Simbolo("Lampara");
    Simbolo barco = new Simbolo("Barco");


    @Test
    public void test01JugadorActivaUnaTarjetaPais() throws NoSePuedeProducirCanjeException {
        Jugador jugadorRojo = new Jugador("Rojo");

        Tarjeta tarjeta = new Tarjeta(argentina, globo);

        jugadorRojo.asignarPais(argentina);
        jugadorRojo.agregarTarjetaAleatoria(tarjeta);
        jugadorRojo.activarTarjeta(tarjeta, mazo);

        Assert.assertEquals(2, argentina.cantidadEjercitos());
    }

    @Test
    public void test02JugadorNoPuedeActivarTarjetaPais() {
        Jugador jugadorRojo = new Jugador("Rojo");

        Tarjeta tarjeta = new Tarjeta(argentina, globo);

        jugadorRojo.agregarTarjetaAleatoria(tarjeta);

        assertThrows(NoSePuedeProducirCanjeException.class, () -> {
           jugadorRojo.activarTarjeta(tarjeta, mazo);
        });
    }

    @Test
    // si un jugador tiene menos de seis paises conquistados se le asigan solo 3 ejercitos para agregar aunque haya hecho un canje
    public void test03JugadorRealizaUnCanjeConTresTarjetasDistintas() throws NoSePuedeProducirCanjeException, EjercitosException {
        Jugador jugadorRojo = new Jugador("Rojo");

        Tarjeta tarjetaGlobo = new Tarjeta(argentina, globo);
        Tarjeta tarjetaLampara = new Tarjeta(argentina, lampara);
        Tarjeta tarjetaBarco = new Tarjeta(argentina, barco);

        List<Tarjeta> tarjetas = Arrays.asList(tarjetaBarco, tarjetaLampara, tarjetaGlobo);

        for (Tarjeta tarjeta : tarjetas) { jugadorRojo.agregarTarjetaAleatoria(tarjeta); }

        jugadorRojo.canjearTarjetas(tarjetas, mazo);

        Assert.assertEquals(4, jugadorRojo.cantidadEjercitosPorColocar());
    }
}
