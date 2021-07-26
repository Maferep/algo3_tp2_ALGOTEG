package edu.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.*;


public class JuegoTest {
    @Test
    public void test01avanzarFasesDeJuego() throws FaseErroneaException, Exception {
        Juego juego = new Juego(3);

        List<IPais> paisesDeUltimo = null;

        for(int i = 0; i < juego.cantidadDePaises(); i++) {
            paisesDeUltimo = juego.jugadorActual().obtenerPaises();
            assertNotEquals(0, paisesDeUltimo);
            juego.ubicarEjercitosEnPais(3, paisesDeUltimo.get(0));
            juego.siguienteTurno();
        }

        List<IPais> paisesDeJugadorActual = juego.jugadorActual().obtenerPaises();
        assertNotEquals(true, paisesDeJugadorActual.isEmpty());
        IPais defensor = paisesDeUltimo.get(0);
        IPais atacante = paisesDeJugadorActual.get(0);

        defensor.agregarAdyacente(atacante);
        atacante.agregarAdyacente(defensor);

        assertNotEquals(null, defensor);
        assertNotEquals(null, atacante);
        assertNotEquals(null, juego.jugadorActual());
        
        juego.siguienteFase();
        juego.atacar(atacante, 3, defensor);

        juego.siguienteFase();
        assertEquals(1, juego.jugadorActual().cantidadTarjetas());
    }

    @Test
    public void test02TransferirEjercitos() throws FaseErroneaException, Exception {
        Juego juego = new Juego(3);

        List<IPais> paisesDeUltimo = null;
        for(int i = 0; i < juego.cantidadDePaises(); i++) {
            paisesDeUltimo = juego.jugadorActual().obtenerPaises();
            juego.ubicarEjercitosEnPais(3, paisesDeUltimo.get(0));
            juego.siguienteTurno();
        }

        List<IPais> paisesDeJugadorActual = juego.jugadorActual().obtenerPaises();
        IPais pais1 = paisesDeJugadorActual.get(0);
        IPais pais2 = paisesDeJugadorActual.get(1);
        pais1.agregarAdyacente(pais2);
        pais2.agregarAdyacente(pais1);
        juego.siguienteFase();
        juego.siguienteFase();
        juego.transferirEjercitos(3, pais1, pais2);
    }
    

    
}