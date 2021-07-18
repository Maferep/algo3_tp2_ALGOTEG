package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

public class JugadorFactoryTest {
    @Test
    public void test01CrearJugador() throws EjercitosException {
        JugadorFactory builder = new JugadorFactory();
        List<String> colores =  Arrays.asList(
        "Azul", 
        "Rojo", 
        "Amarillo", 
        "Verde", 
        "Rosa", 
        "Negro");
        List<Jugador> jugadores = builder.construirJugadores(colores, 5);
        assertEquals(8, jugadores.get(0).cantidadEjercitos());
        assertEquals(8, jugadores.get(4).cantidadEjercitos());
    }
}