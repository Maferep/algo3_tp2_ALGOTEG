package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.fases.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaseAtaqueTest {
    @Test
    public void test00Atacar() throws Exception {
        IPais atacante = new Pais("España");
        IPais defensor = new Pais("Francia");

        atacante.definirConquistador(new Jugador("Rosa"));
        defensor.definirConquistador(new Jugador("Amarillo"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        ITurno turno = new TurnoMock();
        FaseAtacar fase = new FaseAtacar(turno, null);
        fase.atacar(atacante, 1, defensor);
    }

    //Juego de una ronda con 2 jugadores.
    //En esta ronda el jugador 1 ataca y conquista dos países del jugador 2.
    @Test
    public void test01JugadorAtacaYConquistaDosPaisesDelOtroJugador() throws Exception {
        IPais atacante1 = new PaisMock("España");
        IPais defensor1 = new PaisMock("Francia");

        IPais atacante2 = new PaisMock("Argentina");
        IPais defensor2 = new PaisMock("Chile");

        IJugador jugador1 = atacante1.obtenerConquistador();
        IJugador jugador2 = defensor1.obtenerConquistador();
        atacante2.definirConquistador(jugador1);
        defensor2.definirConquistador(jugador2); 

        assertEquals(2, jugador1.obtenerPaises().size());
        assertEquals(2, jugador2.obtenerPaises().size());

        //Primer ataque. El atacante gana.
        ITurno turno = new TurnoMock();
        FaseAtacar fase = new FaseAtacar(turno, null);
        fase.atacar(atacante1, 3, defensor1);

        assertEquals(3, jugador1.obtenerPaises().size());
        assertEquals(1, jugador2.obtenerPaises().size());

        //Segundo ataque. El atacante gana.
        Ataque ataqueFalsoNew = new Ataque(atacante2, defensor2, new DadosUsadosMock(3,0));

        ITurno turnoNew = new TurnoMock();
        FaseAtacar faseNew = new FaseAtacar(turnoNew, null);
        faseNew.atacarConAtaque(ataqueFalsoNew);

        assertEquals(4, jugador1.obtenerPaises().size());
        assertEquals(0, jugador2.obtenerPaises().size());
    }

}
