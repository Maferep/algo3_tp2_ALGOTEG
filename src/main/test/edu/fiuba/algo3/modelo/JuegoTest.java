package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;


public class JuegoTest {
<<<<<<< HEAD

  /*  @Test
    public void test01avanzarFasesDeJuego() throws FaseErroneaException, Exception {
=======
    
    @Test
    public void test00avanzarFaseAvanzaJugador() throws Exception {
>>>>>>> experimental
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
        assertThrows(Exception.class, () -> juego.siguienteTurno());
    }

    @Test
    public void test02VerificarTurno() throws FaseErroneaException, Exception {
        int cantidadJugadores = 3;

        Juego juego = new Juego(cantidadJugadores);

        for(int i = 0; i < cantidadJugadores - 1; i++) {
            juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));
            juego.siguienteTurno();
        }
        juego.ubicarEjercitosEnPais(3, juego.jugadorActual().obtenerPaises().get(0));

<<<<<<< HEAD
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteFase();
        assertEquals(1, juego.jugadorActual().cantidadTarjetas());
    }*/
=======
        //ultimo jugador no puede avanzar al siguiente turno
        assertThrows(TurnoException.class, () -> {
            juego.siguienteTurno();
        });
        juego.siguienteFase(); 
    }
    
    
>>>>>>> experimental

    @Test
    public void test03TransferirEjercitos() throws FaseErroneaException, Exception {
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
    public void test04JugadorObtieneTarjetaAlGanar() throws FaseErroneaException, Exception {
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

    @Test
    public void test05GanarJuegoCon30Paises() throws FaseErroneaException, Exception {
        List<IPais> paisesVarios = Arrays.asList(
            "Estados Unidos",
            "Canadá", 
            "Brasil", 
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador",
            "Canadá2", 
            "Brasil2", 
            "Bolivia2",
            "Colombia2",
            "Chile2",
            "Ecuador2",
            "Canadá3", 
            "Brasil3", 
            "Bolivia3",
            "Colombia3",
            "Chile3",
            "Ecuador3",
            "Canadá4", 
            "Brasil4", 
            "Bolivia4",
            "Colombia4",
            "Chile4",
            "Ecuador4",
            "Canadá5", 
            "Brasil5", 
            "Bolivia5",
            "Colombia5",
            "Chile5",
            "Ecuador5",
            "Canadá6", 
            "Brasil6", 
            "Bolivia6",
            "Colombia6",
            "Chile6",
            "Ecuador6")
            .stream()
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());

        List<IPais> paises = new ArrayList<>();
        //List<IPais> paises = Arrays.asList(new PaisMock("Cambodia"));
        List<IObjetivo> objetivos = Arrays.asList(new ObjetivoGeneral());
        //necesito una fabrica que le pase el objetivoManager mock
        IFabricaDeFases fabrica = new FabricaDeFasesMock();

        //pasarle objetos mock
        ITurno turno = new TurnoMockUnJugador(paises);
        ObjetivoManager objetivoManager = new ObjetivoManager(turno, objetivos);
        fabrica.definirObjetivo(objetivoManager);
        fabrica.definirTurno(turno);

        //crear juego, extraer jugador actual
        Juego juego = new Juego(fabrica, 3);
        IJugador jugador = juego.jugadorActual();

        assertFalse(jugador.cantidadPaises() > 30);

        for (IPais pais : paisesVarios) 
            pais.definirConquistador(jugador);
        
        assertTrue(jugador.cantidadPaises() > 30);
        assertTrue(juego.juegoTerminado);
    }
}