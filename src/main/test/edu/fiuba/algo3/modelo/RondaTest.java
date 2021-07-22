package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.fases.FaseInicio;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Mocks.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {
    List<Pais> paisesJugadorUno = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Italia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    List<Pais> paisesJugadorDos = Arrays.asList(
            "Alemania",
            "Inglaterra",
            "Argentina",
            "Francia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    JuegoFactory juegoBuilder = new JuegoFactory();
    JugadorFactory tipoDeJugador = new JugadorFactory();
    @Test
    public void test00AgregarJugadores() throws Exception {
        juegoBuilder.crearJuegoTEG(3, tipoDeJugador);
    }

    @Test
    public void test01agregarEjercitos() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseInicio fase = new FaseInicio(unJugador);
        assertFalse(fase.faseCompletada());
        fase.asFaseInicio().ubicarEjercitosEnPais(3, new Pais("Estados Unidos"));
        fase.asFaseInicio().ubicarEjercitosEnPais(5, new Pais("Estados Unidos"));
        assertTrue(fase.faseCompletada());
    }

    @Test
    public void test02PasarPorEtapasDistintas() throws Exception {
        //genera una etapa de inicio en estado 'finalizado' de ejemplo
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorDos);
        IFase fase = new FaseInicio(unJugador);
        assertFalse(fase.faseCompletada());

        Pais pais = new Pais("Francia");
        pais.agregarEjercitos(3);
        Pais pais2 = new Pais("Alemania");
        pais2.agregarEjercitos(3);

        fase.asFaseInicio().ubicarEjercitosEnPais(3, pais);
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();

        fase.asFaseAtacar().atacar(pais, 1, pais2);
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();
    }
}
