package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    @Test
    public void test00JugadorConTurnoCorrecto() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(3, 0); //??
        assertEquals(primeraEtapa.cantidadDeJugadores(), 3);
        assertEquals(primeraEtapa.sistemaDeTurnos.ColorDejugadorEnOrden(2), "Rojo");
    }
}
