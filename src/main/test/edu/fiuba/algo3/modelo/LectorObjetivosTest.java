package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LectorObjetivosTest {
    @Test
    public void test01LeerObjetivo() {
        LectorObjetivos lector = new LectorObjetivos();
        List<Map<String, Integer>> listasDeContinentesYSusMinimos = 
            lector.obtenerListasDeContinentesYSusMinimos();
        assertTrue(!listasDeContinentesYSusMinimos.isEmpty());
        assertEquals(-1, listasDeContinentesYSusMinimos.get(0).get("Africa"));
        assertEquals(2, listasDeContinentesYSusMinimos.get(4).get("Oceania"));
    }
}