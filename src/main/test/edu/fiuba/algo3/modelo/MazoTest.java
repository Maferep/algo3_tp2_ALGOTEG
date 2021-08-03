package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IMapa;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Tarjeta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MazoTest {
    IMapa mapa = new Mapa();

    @Test
    public void test01AgarrarTarjeta() {
        Mazo mazo = new Mazo(mapa);
        Tarjeta tarjeta = mazo.obtenerTarjeta();

        Assertions.assertFalse(tarjeta.obtenerSimbolo().simbolo.equals(""));
        Assertions.assertFalse(tarjeta.obtenerPais().obtenerNombre().equals(""));
    }
    
}
