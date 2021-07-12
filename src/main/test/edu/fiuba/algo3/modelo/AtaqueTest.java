package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueTest {
    @Test
    public void test01AtacarPaisGanaDefensor() throws Exception {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Chile");

        atacante.asignarConquistador(new Jugador("Mafer"));
        defensor.asignarConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadoFalso(1,1));
        ataqueFalso.atacar();

        assertEquals("Cande", defensor.obtenerConquistador().obtenerNombre());
        assertEquals(2, atacante.cantidadEjercitos());
    }

    @Test
    public void test02AtacarPaisGanaDefensorYAtacanteSeQuedaConUnSoloSoldado() throws Exception {
        Pais atacante = new Pais("Paraguay");
        Pais defensor = new Pais("Uruguay");

        atacante.asignarConquistador(new Jugador("Martín"));
        defensor.asignarConquistador(new Jugador("Tobías"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadoFalso(0, 2));
        ataqueFalso.atacar();

        assertEquals(1, atacante.ejercitos);
        assertEquals(3, defensor.ejercitos);

        //TODO: corregir error donde Martin conquista
        assertEquals("Tobías", defensor.obtenerConquistador().obtenerNombre());
        assertEquals(3, defensor.cantidadEjercitos());
        assertEquals(1, atacante.cantidadEjercitos());
    }

    @Test
    public void test03AtacarPaisGanaAtacante() throws Exception {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Pepe"));
        defensor.asignarConquistador(new Jugador("Daniel"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);
        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadoFalso(3,0));

        ataqueFalso.atacar();

        //TODO: Prueba no pasada. Revisar código
        assertEquals("Daniel", defensor.obtenerConquistador().obtenerNombre());
        assertEquals(3, atacante.cantidadEjercitos());
        assertEquals(1, defensor.cantidadEjercitos());
    }

    @Test
    public void test04AtacarPaisGanaAtacanteYDefensorSeQuedaSinEjercitos() throws Exception {
        Pais atacante = new Pais("España");
        Pais defensor = new Pais("Francia");

        atacante.asignarConquistador(new Jugador("Chiara"));
        defensor.asignarConquistador(new Jugador("Pili"));

        atacante.agregarEjercitos(4);
        defensor.agregarEjercitos(3);

        Ataque ataqueFalso = new Ataque(atacante, defensor, new DadoFalso(3,0));
        ataqueFalso.atacar();

        assertEquals(atacante.obtenerConquistador().obtenerNombre(), defensor.obtenerConquistador().obtenerNombre());
        assertEquals(0, defensor.cantidadEjercitos());
    }

    //prueba para que atacante si o si deba tener mas de una ficha para atacar


    //TODO: validar que 1. el atacante no ataque con todos sus ejercitos, y 
    //2. ningun soldado use mas de 3 ejercitos
    //3. el atacante tenga ejercitos con los cuales atacar

    @Test
    public void test05AtacanteTrataDeAtacarConTodosSusEjercitos() throws Exception {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Chile");

        atacante.asignarConquistador(new Jugador("Mafer"));
        defensor.asignarConquistador(new Jugador("Cande"));

        atacante.agregarEjercitos(3);
        defensor.agregarEjercitos(3);

        assertThrows(Exception.class, () -> {
                Ataque ataque = new Ataque(atacante, defensor, 3);
                ataque.atacar();
        } );
    }

}

