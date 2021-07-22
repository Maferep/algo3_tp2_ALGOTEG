package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.factories.JugadorFactory;
import edu.fiuba.algo3.modelo.fases.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaseAtaqueTest {
    @Test
    public void test00Atacar() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Rosa"));
        defensor.asignarConquistador(new Jugador("Amarillo"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        ITurno turno = new TurnoMock();
        List<IPais> p = Arrays.asList(atacante, defensor);
        FaseAtacar fase = new FaseAtacar(turno, p, null);
        fase.atacar(atacante, 1, defensor);
    }

    //Juego de una ronda con 2 jugadores.
    //En esta ronda el jugador 1 ataca y conquista dos países del jugador 2.
    @Test
    public void test01JugadorAtacaYConquistaDosPaisesDelOtroJugador() throws Exception {
        Jugador jugador1 = new Jugador("Rosa");
        Jugador jugador2 = new Jugador("Amarillo");

        jugador1.inicializarEjercitos(15);
        jugador1.inicializarEjercitos(15);

        Pais atacante1 = new Pais("España");
        Pais defensor1 = new Pais("Francia");

        Pais atacante2 = new Pais("Argentina");
        Pais defensor2 = new Pais("Chile");

        atacante1.asignarConquistador(jugador1);
        defensor1.asignarConquistador(jugador2);

        atacante2.asignarConquistador(jugador1);
        defensor2.asignarConquistador(jugador2);

        atacante1.agregarEjercitos(4);
        defensor1.agregarEjercitos(3);

        atacante2.agregarEjercitos(4);
        defensor2.agregarEjercitos(3);

        assertEquals(2, jugador1.paises.size());

        //Primer ataque. El atacante gana.
        Ataque ataqueFalso = new Ataque(atacante1, defensor1, new DadosUsadosMock(3,0));

        ITurno turno = new TurnoMock();
        List<IPais> p = Arrays.asList(atacante1, defensor1);
        FaseAtacar fase = new FaseAtacar(turno, p, null);
        fase.atacarConAtaque(ataqueFalso);

        assertEquals(3, jugador1.paises.size());
        assertEquals(1, jugador2.paises.size());

        //Segundo ataque. El atacante gana.
        Ataque ataqueFalsoNew = new Ataque(atacante2, defensor2, new DadosUsadosMock(3,0));

        ITurno turnoNew = new TurnoMock();
        List<IPais> pNew = Arrays.asList(atacante2, defensor2);
        FaseAtacar faseNew = new FaseAtacar(turnoNew, pNew, null);
        faseNew.atacarConAtaque(ataqueFalsoNew);

        assertEquals(4, jugador1.paises.size());
        assertEquals(0, jugador2.paises.size());
    }

}
