package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import edu.fiuba.algo3.modelo.factories.JugadorFactoryMock;
import edu.fiuba.algo3.modelo.factories.JugadorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaseInicioTest {
    JugadorFactory tipoDeJugador = new JugadorFactory();
    @Test
    public void test00AgregarJugadores() throws Exception {
        FaseInicio primeraEtapa = new FaseInicio(3, tipoDeJugador);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01NoSePuedeComenzarElJuegoConMenosDeDosJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
            new FaseInicio(0, tipoDeJugador);
        }
        );
    }

    @Test
    public void test02NoSePuedeComenzarElJuegoConMasDeSeisJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
                    new FaseInicio(7, tipoDeJugador);
                }
        );
    }

    
}
