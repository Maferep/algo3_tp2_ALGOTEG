package edu.fiuba.algo3.modelo.factories;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;

public class TurnoFactory {
    IJugador builder;
    List<String> colores =  Arrays.asList(
        "Azul", 
        "Rojo", 
        "Amarillo", 
        "Verde", 
        "Rosa", 
        "Negro");

    public Turno crearTurno(int cantJugadores, IJugador tipoJugador) throws EjercitosException {
        builder = tipoJugador;
        return new Turno(
            builder.construirJugadores(colores, cantJugadores)
        );
    }

    

}
