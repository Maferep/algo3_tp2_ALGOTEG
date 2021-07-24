package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class Juego implements IFaseInicio, IFaseAtacar, IFaseColocar, IFaseReagrupar {
    IFase faseActual;
    FabricaDeFases fabrica;

    public Juego(int cantidadDeJugadores, IJugador tipoJugador) throws Exception {
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);
    }

    // inicio

    @Override
    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais)
            throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException, FaseErroneaException {
        faseActual.obtenerFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    // reagrupar

    @Override
    public void reagrupar() throws Exception {
        faseActual.obtenerFaseReagrupar().reagrupar();
    }

    // atacar

    @Override
    public void atacar(IPais atacante, int cantidadDeSoldados, IPais defensor) throws Exception {
        faseActual.obtenerFaseAtacar().atacar(atacante, cantidadDeSoldados, defensor);
    }

    //colocar

    @Override
    public void asignarNuevosEjercitosAJugadores() throws EjercitosException, FaseErroneaException {
        faseActual.obtenerFaseColocar().asignarNuevosEjercitosAJugadores();
    }

    @Override
    public void colocarEjercitosEnPais(int cantEjercitos, IPais pais)
            throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError, FaseErroneaException {
        faseActual.obtenerFaseColocar().colocarEjercitosEnPais(cantEjercitos, pais);
    }

    //datos persistentes del juego

    public int cantidadDeJugadores() throws FaseErroneaException {
        return faseActual.obtenerFaseInicio().cantidadDeJugadores();
    }

    //avanzar fase
    public void siguienteFase() throws FaseIncompletaException, EjercitosException {
        faseActual = faseActual.siguienteFase(fabrica);
    }
}