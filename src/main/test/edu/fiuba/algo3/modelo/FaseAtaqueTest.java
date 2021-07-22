package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.fases.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

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
}
