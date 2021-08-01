package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.OrdenadorAleatorio;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapaTest {

    @Test
    public void test00CrearMapa() {
        Mapa mapa = new Mapa();
        List<IPais> paises = mapa.obtenerPaises();

        Assert.assertEquals(50, paises.size());
    }

    @Test
    public void test01MapaAsignaPaises() {
        Mapa mapa = new Mapa();
        List<IJugador> jugadores = Arrays.asList(
                "Rojo",
                "Azul")
                .stream()
                .map(color -> new Jugador(color))
                .collect(Collectors.toList());

        mapa.asignarPaises(jugadores, new OrdenadorAleatorio());

        Assert.assertFalse(jugadores.get(0).obtenerPaises().isEmpty());
        Assert.assertFalse(jugadores.get(1).obtenerPaises().isEmpty());
    }
}
