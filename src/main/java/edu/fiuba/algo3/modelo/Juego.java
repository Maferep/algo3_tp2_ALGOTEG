package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.builders.JuegoBuilder;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;

public class Juego {
    IFase faseActual;
    IJuegoBuilder builder;

    public Juego(int cantidadDeJugadores) throws Exception {
        builder = new JuegoBuilder();
        faseActual = builder.crearJuegoTEG(3);
    }

    public void atacar(Pais atacante, int cantSoldados, Pais defensor) 
        throws FaseErroneaException {
        faseActual.asFaseAtacar().atacar(atacante, cantSoldados, defensor);
    }

    public int cantidadDeJugadores() 
        throws FaseErroneaException {
        return faseActual.asFaseInicio().cantidadDeJugadores();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) 
        throws FaseErroneaException {
        faseActual.asFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    

}