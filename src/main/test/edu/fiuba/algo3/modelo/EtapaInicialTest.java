package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class EtapaInicialTest {
    @Test
    public void test00AgregarJugadores() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(3);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01NoSePuedeComenzarElJuegoConMenosDeDosJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
            EtapaInicial primeraEtapa = new EtapaInicial(0);
        }
        );
    }

    @Test
    public void test02NoSePuedeComenzarElJuegoConMasDeSeisJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
                    EtapaInicial primeraEtapa = new EtapaInicial(7);
                }
        );
    }

    @Test
    public void test03ColocarFichasInicialesParaLosJugadores() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(6);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 6);

        assertEquals(primeraEtapa.jugadores(1).cantidadEjercitos(), 8);

        assertThrows(Exception.class, () -> primeraEtapa.jugadores(8).cantidadEjercitos());
        assertDoesNotThrow(() ->
                primeraEtapa.jugadores(2).cantidadEjercitos());
    }

    @Test
    public void test04AsignarPaisesAJugadores() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(6);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 6);
        assertTrue((primeraEtapa.jugadores(1).obtenerPaises()).size() > 0);
    }

}
