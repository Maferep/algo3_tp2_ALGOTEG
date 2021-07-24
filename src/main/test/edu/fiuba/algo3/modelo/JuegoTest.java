package edu.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;
import edu.fiuba.algo3.modelo.Interfaces.*;


public class JuegoTest {

    List<IPais> paises = Arrays
            .asList(
            "Estados Unidos",
            "Canadá", 
            "Brasil", 
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    @Test
    public void test01avanzarFasesDeJuego() throws FaseErroneaException, Exception {
        Juego juego = new Juego(3);

        List<IPais> paisesDeUltimo = null;

        for(int i = 0; i < juego.cantidadDeJugadores(); i++) {
            paisesDeUltimo = juego.jugadorActual().obtenerPaises();
            assertNotEquals(0, paisesDeUltimo);
            juego.ubicarEjercitosEnPais(3, paisesDeUltimo.get(0));
            juego.siguienteTurno();
        }

        List<IPais> paisesDeJugadorActual = juego.jugadorActual().obtenerPaises();
        IPais defensor = paisesDeUltimo.get(0);
        assertNotEquals(null, defensor);
        
        juego.siguienteFase();
        juego.atacar(paisesDeJugadorActual.get(0), 3, defensor);

        juego.siguienteFase();
        assertEquals(1, juego.jugadorActual().cantidadTarjetas());
    }
}