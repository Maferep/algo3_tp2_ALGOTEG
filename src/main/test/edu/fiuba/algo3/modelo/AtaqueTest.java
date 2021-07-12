package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtaqueTest {
    @Test
    public void test01AtacarPaisGanaDefensor() {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Chile");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor, new DadoFalso(1,1));

       // Boolean conquisto = atacante.atacar(defensor, 1);
        Boolean conquisto = ataqueFalso.atacar(atacante, defensor,1);
        assertEquals(false, conquisto);
        assertEquals(2, atacante.cantidadEjercitos());
    }

    @Test
    public void test02AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() {

        Pais atacante = new Pais("Paraguay");
        Pais defensor = new Pais("Uruguay");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor, new DadoFalso(2, 2));
        Boolean conquisto = ataqueFalso.atacar(atacante, defensor,2);
        assertEquals(false, conquisto);
        assertEquals(1, atacante.cantidadEjercitos());
    }

    @Test
    public void test03AtacarPaisGanaAtacante() {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);
        Ataque ataqueFalso = new Ataque(defensor, new DadoFalso(3,2));
        //Boolean conquisto = atacante.atacar(defensor, 3);
        Boolean conquisto = ataqueFalso.atacar(atacante, defensor,2);
        assertEquals(true, conquisto);
        assertEquals(3, atacante.cantidadEjercitos());
    }

    @Test
    public void test04AtacarPaisGanaAtacanteYDefensorSeQuedaSinEjercitos() {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor, new DadoFalso(3,1));

        //Boolean conquisto = atacante.atacar(defensor, 3);
        Boolean conquisto = ataqueFalso.atacar(atacante, defensor, 3);
        assertEquals(true, conquisto);
        assertEquals(0, defensor.cantidadEjercitos());
    }

    //prueba para que atacante si o si deba tener mas de una ficha para atacar
    @Test
    public void test05AtacanteDebeTenerMasDeUnaFichaParaAtacar() {
        Pais atacante = new Pais("Rusia");
        Pais defensor = new Pais("Noruega");

        atacante.agregarEjercitos(1);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,new DadoFalso(3,3));

        Boolean conquisto = ataqueFalso.atacar(atacante, defensor,4);
        assertEquals(false, conquisto);
    }

    //no puede atacar con 3 fichas teniendo 3 fichas
    @Test
    public void test06AtacanteNoPuedeAtacarConLaMismaCantidadDeFichasQuePosee() {

        Pais atacante = new Pais("Rusia");
        Pais defensor = new Pais("Noruega");

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(defensor,new DadoFalso(3,3));
        Boolean conquisto = ataqueFalso.atacar(atacante, defensor, 3);
        assertEquals(false, conquisto);
    }
}

