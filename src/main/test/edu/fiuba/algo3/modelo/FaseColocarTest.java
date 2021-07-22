package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Mocks.JugadorFactoryMock;
import edu.fiuba.algo3.modelo.Mocks.TurnoMockUnJugador;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;
import edu.fiuba.algo3.modelo.factories.JuegoFactory;
import edu.fiuba.algo3.modelo.fases.FaseInicio;
import edu.fiuba.algo3.modelo.fases.FaseColocar;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FaseColocarTest {
    List<Pais> paisesJugadorUno = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Italia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    List<Pais> paisesJugadorDos = Arrays.asList(
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    //Juego de una ronda con 2 jugadores.
    //En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test00RondaDeDosJugadoresSinAtaques() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno);
        Pais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador,paisesJugadorDos);
        Pais paisNuevo = new Pais("Bolivia");
        faseNueva.ubicarEjercitosEnPais(2, paisNuevo);
        assertTrue(faseNueva.faseCompletada());
        assertEquals(paisNuevo.cantidadEjercitos(), 2);
    }

    @Test
    public void test01RondaDeDosJugadoresNoHaySuficientesFichasParaAgregarAUnPais() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno);
        Pais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador,paisesJugadorDos);
        Pais paisNuevo = new Pais("Bolivia");
        assertThrows(FichasInsuficientesError.class, () -> {
            faseNueva.ubicarEjercitosEnPais(1000, paisNuevo);
        } );
    }

    @Test
    public void test03NoExistePaisError() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno);
        Pais pais = new Pais("Estados Unidos");
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);

        ITurno unSegundoJugador = new TurnoMockUnJugador(paisesJugadorDos);
        FaseColocar faseNueva = new FaseColocar(unSegundoJugador,paisesJugadorDos);
        Pais paisNuevo = new Pais("Belgica");
        assertThrows(PaisNoExistenteError.class, () -> {
            faseNueva.ubicarEjercitosEnPais(1, paisNuevo);
        } );
    }
}
