package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import edu.fiuba.algo3.modelo.Interfaces.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MazoFachadaTest {
    IMapa mapa = new Mapa();

    @Test
    public void test01CrearMazo() {
        MazoFachada mazo = new MazoFachada(mapa);
        LinkedList<Tarjeta> tarjetas = mazo.obtenerTarjetas();

        Assert.assertEquals(50, tarjetas.size());
    }

}