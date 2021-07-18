package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaseAtaqueTest {
    @Test
    public void test00Atacar() throws Exception {
        FaseAtacar fase = new FaseAtacar(new FaseInicioMock());
        fase.atacar(null, 0, null);
    }
}
