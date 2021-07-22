package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.fases.FaseInicio;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;

public class Juego {
    IFase faseActual;

    public Juego(int cantidadDeJugadores, IJugador tipoJugador) throws Exception {
        faseActual = crearJuegoTEG(3);
    }
    public void completarEtapaInicio(int cantEjercitos, IPais pais) throws FaseErroneaException, EjercitosException, FichasInsuficientesError, PaisNoExistenteError {
        faseActual.asFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    public static IFase crearJuegoTEG(int cantJugadores) throws Exception {
        return new FaseInicio(cantJugadores);
    }

    

}