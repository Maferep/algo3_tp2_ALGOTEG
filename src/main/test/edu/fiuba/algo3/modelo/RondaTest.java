package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
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
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());
    List<IPais> paisesJugadorDos = Arrays.asList(
            "Alemania",
            "Inglaterra",
            "Argentina",
            "Francia")
            .stream()
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());
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
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());

    @Test
    public void test00AgregarJugadores() throws Exception {
        FabricaDeFases fabrica = new FabricaDeFases();

        int cantidadEjercitos = 3;

        IFase fase = fabrica.crearFaseInicio(cantidadEjercitos);
        assertEquals(3, fase.obtenerFaseInicio().cantidadDeJugadores());
    }

    @Test
    public void test01agregarEjercitos() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorUno);
        FaseInicio fase = new FaseInicio(null, unJugador, new Canje(paises));
        assertFalse(fase.faseCompletada());

        int primerCantidadEjercitos = 3;
        int segundaCantidadEjercitos = 5;

        fase.obtenerFaseInicio().ubicarEjercitosEnPais(primerCantidadEjercitos, new Pais("Estados Unidos"));
        fase.obtenerFaseInicio().ubicarEjercitosEnPais(segundaCantidadEjercitos, new Pais("Estados Unidos"));
        assertTrue(fase.faseCompletada());
    }

    @Test
    public void test02PasarPorEtapasDistintas() throws Exception {
        //genera una etapa de inicio en estado 'finalizado' de ejemplo
        ITurno unJugador = new TurnoMockUnJugador(paisesJugadorDos);
        IFase fase = new FaseInicio(null, unJugador, new Canje(paises));
        assertFalse(fase.faseCompletada());

        int cantidadEjercitos = 3;

        fase.obtenerFaseInicio().ubicarEjercitosEnPais(cantidadEjercitos, paisesJugadorDos.get(0));
        assertTrue(fase.faseCompletada());
        fase = fase.siguienteFase(new FabricaDeFases());
    }

    @Test
    public void test04ConquistaCausaAsignacionDeTarjeta() throws FaseErroneaException, Exception {
        ITurno turnoMock = new TurnoMockUnJugador(paises);
        IMapa mapa = new Mapa();
        mapa.definirPaises(paises);
        IFase fase = new FaseAtacar(turnoMock, mapa);
        IPais mockAtacanteSiempreGana = new PaisMock("Rojo");
        IPais mockDefensor = new PaisMock("Azul");

        assertEquals(0, turnoMock.jugadorActual().cantidadTarjetas());

        int cantidadEjercitos = 3;

        fase.obtenerFaseAtacar().atacar(mockAtacanteSiempreGana, cantidadEjercitos, mockDefensor);

        FabricaDeFases fabrica = new FabricaDeFases();
        fabrica.definirTurno(turnoMock);
        fabrica.definirCanje(new Canje(paises));
        fabrica.definirMapa(mapa);
        fase = fase.siguienteFase(fabrica);
        assertEquals(1, turnoMock.jugadorActual().cantidadTarjetas());
    }
    @Test
    public void test05NoAtaqueImplicaNoTarjetas() throws FaseErroneaException, Exception {
        ITurno t = new TurnoMockUnJugador(paisesJugadorUno);
        IMapa mapa = new Mapa();
        mapa.definirPaises(paises);
        IFase fase = new FaseAtacar(t, mapa);

        assertEquals(0, t.jugadorActual().cantidadTarjetas());
        fase = fase.siguienteFase(new FabricaDeFases());
        assertEquals(0, t.jugadorActual().cantidadTarjetas());
    }

    @Test
    public void test06NoConquistaImplicaNoTarjetas() throws FaseErroneaException, Exception {
        ITurno t = new TurnoMockUnJugador(paisesJugadorUno);
        IMapa mapa = new Mapa();
        mapa.definirPaises(paises);
        IFase fase = new FaseAtacar(t, mapa);
        IPais mockAtacanteSiemprePierde = new PaisMockSiemprePierde("Rojo");
        IPais mockDefensor = new PaisMock("Azul");

        assertEquals(0, t.jugadorActual().cantidadTarjetas());

        int cantidadEjercitos = 3;

        fase.obtenerFaseAtacar().atacar(mockAtacanteSiemprePierde, cantidadEjercitos, mockDefensor);
        fase = fase.siguienteFase(new FabricaDeFases());
        assertEquals(0, t.jugadorActual().cantidadTarjetas());
    }
}
