package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    @Test
    public void test00JugadorConTurnoCorrecto() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(4, 2); //??
        assertEquals(primeraEtapa.cantidadDeJugadores(), 4);
        assertEquals(primeraEtapa.sistemaDeTurnos.colorDejugadorEnOrden(0), "Azul");
        assertEquals(primeraEtapa.sistemaDeTurnos.colorDejugadorEnOrden(1), "Rojo");
        //assertEquals(primeraEtapa.sistemaDeTurnos.cantidad(), 2);
        assertEquals(primeraEtapa.sistemaDeTurnos.colorDejugadorEnOrden(2), "Amarillo");
        //assertEquals(primeraEtapa.sistemaDeTurnos.ColorDejugadorEnOrden(3), "Verde");
    }
}
