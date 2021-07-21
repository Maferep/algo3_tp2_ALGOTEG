package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Mocks.JugadorFactoryMock;
import edu.fiuba.algo3.modelo.Mocks.TurnoMockUnJugador;
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
    List<Pais> paisesJugadorTres = Arrays.asList(
            "Mexico",
            "Inglaterra",
            "Argentina",
            "Rusia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    //Juego de una ronda con 2 jugadores.
    //En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test00RondaDeDosJugadoresSinAtaques() throws Exception {
        // fase inicial
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        new FaseInicio(unJugador);
        FaseColocar fase = new FaseColocar(unJugador,paisesJugadorUno);
        Pais pais = new Pais("Estados Unidos");
        // fase juego : colocar
        fase.ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        assertEquals(pais.cantidadEjercitos(), 3);
    }
}
