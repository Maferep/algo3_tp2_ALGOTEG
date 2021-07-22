package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.fases.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {
    List<IPais> paisesJugadorUno = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Italia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    List<IPais> paisesJugadorDos = Arrays.asList(
            "Alemania",
            "Inglaterra",
            "Argentina",
            "Francia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    JuegoFactory juegoBuilder = new JuegoFactory();
    JugadorFactory tipoDeJugador = new JugadorFactory();
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
    public void test00AgregarJugadores() throws Exception {
        juegoBuilder.crearJuegoTEG(3);
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

        fase.asFaseInicio().ubicarEjercitosEnPais(3, paisesJugadorDos.get(0));
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase();
    }

    @Test
    public void test04ConquistaCausaAsignacionDeTarjeta() throws FaseErroneaException, Exception {
        ITurno t = new TurnoMockUnJugador(null);
        IFase fase = new FaseAtacar(t, paises, new Canje(paises));
        IPais mockAtacanteSiempreGana = new PaisMock("Rojo");
        IPais mockDefensor = new PaisMock("Azul");

        assertEquals(0, t.jugadorActual().cantidadTarjetas());
        fase.asFaseAtacar().atacar(mockAtacanteSiempreGana, 3, mockDefensor);
        fase = fase.siguienteFase();
        assertEquals(1, t.jugadorActual().cantidadTarjetas());
    }
    @Test
    public void test05NoAtaqueImplicaNoTarjetas() throws FaseErroneaException, Exception {
        ITurno t = new TurnoMockUnJugador(null);
        IFase fase = new FaseAtacar(t, paises, new Canje(paises));

        assertEquals(0, t.jugadorActual().cantidadTarjetas());
        fase = fase.siguienteFase();
        assertEquals(0, t.jugadorActual().cantidadTarjetas());
    }

    @Test
    public void test06NoConquistaImplicaNoTarjetas() throws FaseErroneaException, Exception {
        ITurno t = new TurnoMockUnJugador(null);
        IFase fase = new FaseAtacar(t, paises, new Canje(paises));
        IPais mockAtacanteSiemprePierde = new PaisMockSiemprePierde("Rojo");
        IPais mockDefensor = new PaisMock("Azul");

        assertEquals(0, t.jugadorActual().cantidadTarjetas());
        fase.asFaseAtacar().atacar(mockAtacanteSiemprePierde, 3, mockDefensor);
        fase = fase.siguienteFase();
        assertEquals(0, t.jugadorActual().cantidadTarjetas());
    }
}
