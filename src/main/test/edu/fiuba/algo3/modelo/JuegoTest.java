package edu.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;


public class JuegoTest {
    
    @Test
    public void test00avanzarFaseAvanzaJugador() throws Exception {
        int cantidadJugadores = 3;
        Juego juego = new Juego(cantidadJugadores);
        IJugador primerJugador = juego.jugadorActual();
        
        for(int i = 0; i < cantidadJugadores - 1; i++) {
            juego.ubicarEjercitosEnPais(3, 
                juego.jugadorActual().obtenerPaises().get(0));
            juego.siguienteTurno();
        }
        IJugador ultimoJugador = juego.jugadorActual();
        juego.siguienteFase();
        assertNotEquals(ultimoJugador, juego.jugadorActual());
        assertEquals(primerJugador, juego.jugadorActual());
    }

    @Test
    public void test01NoPuedeSeguirTurnoSinAsignarSusEjercitos() throws Exception {
        int cantidadJugadores = 3;
        Juego juego = new Juego(cantidadJugadores);
        IJugador primerJugador = juego.jugadorActual();
        assertThrows(Exception.class, () -> juego.siguienteTurno());
    }

    @Test
    public void test04VerificarTurno() throws FaseErroneaException, Exception {
        int cantidadJugadores = 3;

        Juego juego = new Juego(cantidadJugadores);

        IJugador jugadorActual = juego.jugadorActual();

        for(int i = 0; i < cantidadJugadores - 1; i++) {
            assertNotEquals(0, juego.jugadorActual().cantidadPaises());
            juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));
            juego.siguienteTurno();
        }
        assertNotEquals(0, juego.jugadorActual().cantidadPaises());
        juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));
        juego.siguienteFase(); 
    }
    
    @Test
    public void test05JugarBatalla() throws FaseErroneaException, Exception {
        int cantidadJugadores = 3;

        Juego juego = new Juego(cantidadJugadores);
        for(int i = 0; i < cantidadJugadores - 1; i++) {
            juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));
            juego.siguienteTurno();
        }
        IJugador jugadorAPerder = juego.jugadorActual();
        juego.siguienteFase();

        List<IPais> paisesDeJugadorActual = juego.jugadorActual().obtenerPaises();
        assertNotEquals(true, paisesDeJugadorActual.isEmpty());

        //obtener un pais arbitrario del último jugador
        IPais defensor = jugadorAPerder.obtenerPaises().get(0);

        //asignar un pais mock al jugador actual
        IPais atacante = new PaisMock("Siempregania");
        juego.jugadorActual().inicializarPais(atacante);

        //agregamos adyacencia manualmente para test
        defensor.agregarAdyacente(atacante);
        atacante.agregarAdyacente(defensor);

        assertNotEquals(null, defensor);
        assertNotEquals(null, atacante);
        assertNotEquals(null, juego.jugadorActual());

        assertNotEquals(null, defensor.obtenerConquistador());

        assertEquals(atacante.obtenerConquistador(), juego.jugadorActual());
        juego.atacar(atacante, 1, defensor);

        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteFase();

        //como siempregania siempre gana, el jugador obtiene una tarjeta
        assertEquals(1, juego.jugadorActual().cantidadTarjetas());
        assertEquals(0, jugadorAPerder.cantidadTarjetas());
    }

    @Test
    public void test02TransferirEjercitos() throws FaseErroneaException, Exception {
        int cantidadDeJugadores = 3;
        int cantidadDeEjercitos = 3;
        Juego juego = new Juego(cantidadDeJugadores);

        List<IPais> paisesDeUltimo = null;

        paisesDeUltimo = juego.jugadorActual().obtenerPaises();
        juego.ubicarEjercitosEnPais(cantidadDeJugadores, paisesDeUltimo.get(0));
        for(int i = 0; i < cantidadDeJugadores - 1; i++) {
            juego.siguienteTurno();
            paisesDeUltimo = juego.jugadorActual().obtenerPaises();
            juego.ubicarEjercitosEnPais(cantidadDeJugadores, paisesDeUltimo.get(0));
            
        }

        List<IPais> paisesDeJugadorActual = juego.jugadorActual().obtenerPaises();
        IPais pais1 = paisesDeJugadorActual.get(0);
        IPais pais2 = paisesDeJugadorActual.get(1);
        pais1.agregarAdyacente(pais2);
        pais2.agregarAdyacente(pais1);

        juego.siguienteFase();

        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteFase();
        juego.transferirEjercitos(cantidadDeEjercitos, pais1, pais2);
    }
    
    @Test
    public void test03JugadorObtieneTarjetaAlGanar() throws FaseErroneaException, Exception {
        int cantidadJugadores = 3;

        Juego juego = new Juego(cantidadJugadores);

        IJugador jugadorAPerder = null;

        jugadorAPerder = juego.jugadorActual();
        assertNotEquals(0, juego.jugadorActual().cantidadPaises());
        juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));
            
        for(int i = 0; i < cantidadJugadores - 1; i++) {
            juego.siguienteTurno();
            jugadorAPerder = juego.jugadorActual();
            assertNotEquals(0, juego.jugadorActual().cantidadPaises());
            juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));  
        }
        juego.siguienteFase();

        assertNotEquals(juego.jugadorActual(), jugadorAPerder);
        
        IPais defensor = new Pais("UnPais");
        jugadorAPerder.inicializarPais(defensor);

        IPais atacante = new PaisMock("Siempregania");
        juego.jugadorActual().inicializarPais(atacante);

        defensor.agregarAdyacente(atacante);
        atacante.agregarAdyacente(defensor);

        assertNotEquals(null, defensor);
        assertNotEquals(null, atacante);
        assertNotEquals(null, juego.jugadorActual());

        assertNotEquals(null, defensor.obtenerConquistador());
        
        assertEquals(atacante.obtenerConquistador(), juego.jugadorActual());
        juego.atacar(atacante, 1, defensor);

        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteFase();

        //como siempregania siempre gana, el jugador obtiene una tarjeta
        assertEquals(1, juego.jugadorActual().cantidadTarjetas());
        assertEquals(0, jugadorAPerder.cantidadTarjetas());
    }

    
}