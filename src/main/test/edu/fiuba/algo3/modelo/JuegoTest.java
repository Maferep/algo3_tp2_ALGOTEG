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
    public void test04ConquistaCausaAsignacionDeTarjeta() throws FaseErroneaException, Exception {
        Juego juego = new Juego(3);

        List<IPais> paises = juego.obtenerMapa().obtenerPaises();
        List<IPais> paisesDeJugador;

        for(int i = 0; i < juego.cantidadDeJugadores(); i++) {
            paisesDeJugador = juego.jugadorActual().obtenerPaises();
            assertNotEquals(0, paisesDeJugador);
            juego.ubicarEjercitosEnPais(3, paisesDeJugador.get(0));
            juego.siguienteTurno();
        }
        
        juego.atacar(mockAtacanteSiempreGana, 3, mockDefensor);

        FabricaDeFases fabrica = new FabricaDeFases();
        fabrica.definirTurno(turnoMock);
        fabrica.definirCanje(new Canje(paises));
        fabrica.definirMapa(mapa);
        fase = fase.siguienteFase(fabrica);
        assertEquals(1, turnoMock.jugadorActual().cantidadTarjetas());
    }
}