package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.factories.JuegoFactory;
import edu.fiuba.algo3.modelo.fases.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FaseColocarTest {
    List<IPais> paisesJugadorUno = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Italia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    List<IPais> paisesJugadorDos = Arrays.asList(
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
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
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno, null);
        IPais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador,paisesJugadorDos, null);
        IPais paisNuevo = new Pais("Bolivia");
        faseNueva.ubicarEjercitosEnPais(2, paisNuevo);
        assertTrue(faseNueva.faseCompletada());
        assertEquals(paisNuevo.cantidadEjercitos(), 2);
    }

    @Test
    public void test01RondaDeDosJugadoresNoHaySuficientesFichasParaAgregarAUnPais() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno, null);
        Pais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador,paisesJugadorDos, null);
        Pais paisNuevo = new Pais("Bolivia");
        assertThrows(FichasInsuficientesError.class, () -> {
            faseNueva.ubicarEjercitosEnPais(1000, paisNuevo);
        } );
    }

    @Test
    public void test03NoExistePaisError() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno, null);
        Pais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador,paisesJugadorDos, null);
        Pais paisNuevo = new Pais("Belgica");
        assertThrows(PaisNoExistenteError.class, () -> {
            faseNueva.ubicarEjercitosEnPais(1, paisNuevo);
        } );
    }

    @Test
    public void test04RondaDeTresJugadoresJugadorControlaAsia() throws Exception {
        Continente asia = new Continente(paisesAsia);

        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador, paisesJugadorUno, null);
        IPais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesAsia);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador, paisesAsia, null);

        paisesAsia.forEach(paisAsia -> paisAsia.asignarConquistador(unJugador.jugadorActual()));

        faseNueva.ubicarEjercitosEnPais(2,  paisesAsia.get(0));
        assertTrue(faseNueva.faseCompletada());
        assertEquals( paisesAsia.get(0).cantidadEjercitos(), 2);
        assertTrue(asia.fueConquistadoPor(unSegundoJugador.jugadorActual()));

        ITurno unTercerJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseTercer = new FaseColocar(unTercerJugador, paisesJugadorDos, null);
        IPais paisTercer = new Pais("Chile");
        faseTercer.ubicarEjercitosEnPais(3, paisTercer);
        assertTrue(faseTercer.faseCompletada());
        assertEquals(paisTercer.cantidadEjercitos(), 3);

    }
}
