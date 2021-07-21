package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;

public class Juego {
    IFase faseActual;
    JuegoFactory builder;

    public Juego(int cantidadDeJugadores) throws Exception {
        builder = new JuegoFactory();
        faseActual = builder.crearJuegoTEG(3);
    }

    public void atacar(Pais atacante, int cantSoldados, Pais defensor, Ataque tipoAtaque) throws FaseErroneaException {
        faseActual.asFaseAtacar().atacar(atacante, cantSoldados, defensor, tipoAtaque);
    }

    public int cantidadDeJugadores() 
        throws FaseErroneaException {
        return faseActual.asFaseInicio().cantidadDeJugadores();
    }

    public void completarEtapaInicio(int cantEjercitos, Pais pais) throws FaseErroneaException, EjercitosException {
        faseActual.asFaseInicio().asignarEjercitosAJugadores();
        faseActual.asFaseInicio().asignarPaisesAleatoriamenteAJugadores();
        faseActual.asFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    

}