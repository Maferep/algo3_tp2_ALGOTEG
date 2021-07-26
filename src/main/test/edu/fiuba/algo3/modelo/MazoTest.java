package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import org.junit.Test;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;

import static org.junit.Assert.assertEquals;
public class MazoTest {

    List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá", 
            "Brasil", 
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
        .stream()
        .map(pais -> new Pais(pais))
        .collect(Collectors.toList());
    @Test
    public void test01MazoDePaises() {
        Canje mazo = new Canje(paises);
        IPais eeuu = paises.stream()
            .filter(pais -> pais.obtenerNombre().equals("Estados Unidos"))
            .findAny()
            .get();
        assertEquals(eeuu, mazo.obtenerTarjeta().obtenerPais());
    }

    @Test
    public void test02ProbarTarjeta() {
        IPais austria = new PaisMock("Austria");
        Tarjeta tarjeta = new Tarjeta(austria);
        assertEquals(tarjeta.obtenerPais(), austria);
    }
}