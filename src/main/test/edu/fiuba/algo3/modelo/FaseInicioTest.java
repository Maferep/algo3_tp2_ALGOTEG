package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import org.junit.jupiter.api.Test;

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
            new EtapaInicial(0);
        }
        );
    }

    @Test
    public void test02NoSePuedeComenzarElJuegoConMasDeSeisJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
                    new EtapaInicial(7);
                }
        );
    }

    //TODO: evitar acceso directo por getter a Jugador
    @Test
    public void test03ColocarFichasInicialesParaLosJugadores() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(6);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 6);

        assertEquals(primeraEtapa.obtenerJugador(1).cantidadEjercitos(), 8);

        assertThrows(Exception.class, () -> primeraEtapa.obtenerJugador(8).cantidadEjercitos());
        assertDoesNotThrow(() ->
                primeraEtapa.obtenerJugador(2).cantidadEjercitos());
    }

    //TODO: evitar acceso por getter a Jugador
    @Test
    public void test04AsignarPaisesAJugadores() throws Exception {
        EtapaInicial primeraEtapa = new EtapaInicial(6);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 6);
        assertTrue((primeraEtapa.obtenerJugador(1).obtenerPaises()).size() > 0);
    }

}
