package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class Juego implements IFaseInicio, IFaseAtacar, IFaseColocar, IFaseReagrupar {
    IFase faseActual;
    FabricaDeFases fabrica = new FabricaDeFases();

    IMapa mapa;
    ITurno turno;
    Canje canje;

    public Juego(final int cantidadDeJugadores) throws Exception {
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);

        mapa = faseActual.obtenerFaseInicio().obtenerMapa();
        turno = faseActual.obtenerFaseInicio().obtenerTurno();
        canje = faseActual.obtenerFaseInicio().obtenerCanje();
    }

    // inicio

    @Override
    public void ubicarEjercitosEnPais(final int cantEjercitos, final IPais pais)
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
    public void atacar(final IPais atacante, final int cantidadDeSoldados, final IPais defensor) throws Exception {
        faseActual.obtenerFaseAtacar().atacar(atacante, cantidadDeSoldados, defensor);
    }

    //colocar

    @Override
    public void asignarNuevosEjercitosAJugadores() throws EjercitosException, FaseErroneaException {
        faseActual.obtenerFaseColocar().asignarNuevosEjercitosAJugadores();
    }

    @Override
    public void colocarEjercitosEnPais(final int cantEjercitos, final IPais pais)
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

    @Override
    public Canje obtenerCanje() {
        return canje;
    }

    @Override
    public IMapa obtenerMapa() {
        // TODO Auto-generated method stub
        return mapa;
    }

    @Override
    public ITurno obtenerTurno() {
        // TODO Auto-generated method stub
        return turno;
    }

	public IJugador jugadorActual() {
		return turno.jugadorActual();
	}

	public void siguienteTurno() {
		faseActual.siguienteTurno();
		
	}
}