package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class FaseAtaqueTest {
    @Test
    public void test00Atacar() throws Exception {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Rosa"));
        defensor.asignarConquistador(new Jugador("Amarillo"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);
        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadosUsadosMock(3,0));
        FaseAtacar fase = new FaseAtacar(new FaseInicioMock());
        fase.atacar(atacante, atacante.cantidadEjercitos(), defensor, ataqueFalso);
    }
}
