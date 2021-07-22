package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;

public class Juego {
    IFase faseActual;
    JuegoFactory builder;

    public Juego(int cantidadDeJugadores, IJugador tipoJugador) throws Exception {
        builder = new JuegoFactory();
        faseActual = builder.crearJuegoTEG(3);
    }

    public void atacar(IPais atacante, int cantSoldados, IPais defensor) 
        throws Exception {
        faseActual.asFaseAtacar().atacar(atacante, cantSoldados, defensor);
    }

    public int cantidadDeJugadores() 
        throws FaseErroneaException {
        return faseActual.asFaseInicio().cantidadDeJugadores();
    }

    public void completarEtapaInicio(int cantEjercitos, IPais pais) throws FaseErroneaException, EjercitosException, FichasInsuficientesError, PaisNoExistenteError {
        faseActual.asFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    

}