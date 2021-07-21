package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.fases.*;
import static org.junit.jupiter.api.Assertions.*;

public class FaseInicioTest {
    @Test
    public void test00AgregarJugadores() throws Exception {
        FaseInicio primeraEtapa = new FaseInicio(3);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01NoSePuedeComenzarElJuegoConMenosDeDosJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
            new FaseInicio(0);
        }
        );
    }

    @Test
    public void test02NoSePuedeComenzarElJuegoConMasDeSeisJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
                    new FaseInicio(7);
                }
        );
    }

    
}
