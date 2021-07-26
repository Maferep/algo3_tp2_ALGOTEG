package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FaseColocarTest {
    List<IPais> listaDePaises = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Italia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    List<IPais> paisesAsia = Arrays.asList(
            "China",
            "Japón",
            "Tailandia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    //Juego de una ronda con 2 jugadores.
    //En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test00RondaDeDosJugadoresSinAtaques() throws Exception {
        ITurno unJugador = new TurnoMockUnJugadorPorPais(listaDePaises);
        FaseColocar fase = new FaseColocar(
            unJugador,
            new MapaMock(listaDePaises), 
            new Canje(listaDePaises));
        IPais pais = listaDePaises.get(0);
        fase.colocarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        fase.siguienteTurno();

        IPais paisNuevo = listaDePaises.get(1);
        fase.colocarEjercitosEnPais(3, paisNuevo);
        assertTrue(fase.faseCompletada());
        assertEquals(paisNuevo.cantidadEjercitos(), 3);
    }

    @Test
    public void test01RondaDeDosJugadoresNoHaySuficientesFichasParaAgregarAUnPais() throws Exception {
        ITurno unJugador = new TurnoMockUnJugadorPorPais(listaDePaises);
        FaseColocar fase = new FaseColocar(
            unJugador,
            new MapaMock(listaDePaises), 
            new Canje(listaDePaises));
        IPais pais = listaDePaises.get(0);
        fase.colocarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        fase.siguienteTurno();

        IPais paisNuevo = listaDePaises.get(1);
        assertThrows(FichasInsuficientesError.class, () -> {
            fase.colocarEjercitosEnPais(1000, paisNuevo);
        });
    }

    @Test
    public void test03NoExistePaisError() throws Exception {
        ITurno unJugador = new TurnoMockUnJugadorPorPais(listaDePaises);
        FaseColocar fase = new FaseColocar(
            unJugador,
            new MapaMock(listaDePaises), 
            new Canje(listaDePaises));
        Pais pais = new Pais("Estados Unidos");
        fase.colocarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        fase.siguienteTurno();

        Pais paisNuevo = new Pais("Belgica");
        assertThrows(PaisNoExistenteError.class, () -> {
            fase.colocarEjercitosEnPais(1, paisNuevo);
        });
    }

    @Test
    public void test04RondaDeTresJugadoresJugadorControlaAsia() throws Exception {
        Continente asia = new Continente(paisesAsia);

        ITurno turno = new TurnoMockUnJugadorPorPais(listaDePaises);
        FaseColocar fase = new FaseColocar(turno,new MapaMock(listaDePaises), null);

        IPais pais = listaDePaises.get(0);
        fase.colocarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        // seguir al jugador 2
        fase.siguienteTurno();

        assertEquals(3, turno.jugadorActual().cantidadEjercitos());
        paisesAsia.forEach(paisAsia -> paisAsia.definirConquistador(turno.jugadorActual()));

        fase.colocarEjercitosEnPais(3, paisesAsia.get(0));
        assertEquals(paisesAsia.get(0).cantidadEjercitos(), 3);
        
        assertTrue(fase.faseCompletada());
        assertTrue(asia.fueConquistadoPor(turno.jugadorActual()));

        // seguir al jugador 3
        fase.siguienteTurno();
        assertEquals(3, turno.jugadorActual().cantidadEjercitos());

        IPais paisTercer = listaDePaises.get(2);
        fase.colocarEjercitosEnPais(3, paisTercer);
        assertTrue(fase.faseCompletada());
        assertEquals(paisTercer.cantidadEjercitos(), 3);

    }

    @Test
    public void colocarEjercitosEnPaisNoAfectaOtrosJugadores()
            throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError, TurnoException,
            FaseIncompletaException {

        // setup paises y turno
        List<IPais> paises = Arrays.asList("Bolivia", "Colombia").stream().map(n -> new Pais(n))
                .collect(Collectors.toList());

        IPais colombia = paises.get(1);
        ITurno turno = new TurnoMockUnJugadorPorPais(paises);
        assertEquals(2, turno.cantidadDeJugadores());

        // inicializa fase, lo que da ejercitos a todos los jugadores
        IMapa mapa = new Mapa();
        mapa.definirPaises(listaDePaises);
        FaseColocar fase = new FaseColocar(turno, mapa, null);

        // verificar cantidad de ejercitos de jugador 1 es 3
        IJugador j1 = turno.jugadorActual();
        assertEquals(j1.cantidadEjercitos(), 3);

        // jugador 2 ubica sus paises
        turno.siguienteJugador();
        fase.colocarEjercitosEnPais(3, colombia);
        assertEquals(colombia.cantidadEjercitos(), 3);

        //la cantidad de ejercitos de jugador 1 es 3
        turno.siguienteJugador();
        assertEquals(j1, turno.jugadorActual());
        assertEquals(turno.jugadorActual().cantidadEjercitos(), 3);
    }

    @Test
    public void test06VerificarCantidadEjercitos() throws EjercitosException, TurnoException, FaseIncompletaException {
        ITurno turno = new TurnoMockUnJugadorPorPais(listaDePaises);
        assertEquals(turno.cantidadDeJugadores(), 4);
        assertEquals(0, turno.jugadorActual().cantidadEjercitos());

        FaseColocar fase = new FaseColocar(turno,new MapaMock(listaDePaises), null);
        assertEquals(3, turno.jugadorActual().cantidadEjercitos());
    }

    @Test
    public void test06VerificarFaseCompletada() throws EjercitosException, TurnoException, FaseIncompletaException {
        ITurno turno = new TurnoMockUnJugadorPorPais(listaDePaises);

        FaseColocar fase = new FaseColocar(turno,new MapaMock(listaDePaises), null);
        assertFalse(fase.faseCompletada());
    }
}
