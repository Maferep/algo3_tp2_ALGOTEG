package edu.fiuba.algo3.modelo.builders;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class TurnoBuilder {

    JugadorBuilder builder = new JugadorBuilder();
    List<String> colores =  Arrays.asList(
        "Azul", 
        "Rojo", 
        "Amarillo", 
        "Verde", 
        "Rosa", 
        "Negro");

    public Turno crearTurno(int cantJugadores) throws EjercitosException {
        return new Turno(
            builder.construirJugadores(colores, cantJugadores)
        );
    }

    

}
