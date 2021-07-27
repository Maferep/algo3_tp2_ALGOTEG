package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class Juego implements IFaseInicio, IFaseAtacar, IFaseColocar, IFaseReagrupar {
    IFase faseActual;
    FabricaDeFases fabrica = new FabricaDeFases();

    IMapa mapa;
    ITurno turno;
    Mazo mazo;

    public Juego(final int cantidadDeJugadores) throws Exception {
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);

        mapa = faseActual.obtenerFaseInicio().obtenerMapa();
        turno = faseActual.obtenerFaseInicio().obtenerTurno();
        mazo = faseActual.obtenerFaseInicio().obtenerCanje();
    }

    // inicio

    @Override
    public void ubicarEjercitosEnPais(final int cantEjercitos, final IPais pais)
            throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException, FaseErroneaException {
        faseActual.obtenerFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    // reagrupar

    @Override
    public void transferirEjercitos(int cantidad, IPais unPais, IPais otroPais) throws 
            FaseErroneaException,
            TransferirEjercitosException {
        faseActual.obtenerFaseReagrupar().transferirEjercitos(cantidad, unPais, otroPais);
    }

    // atacar

    @Override
    public void atacar(final IPais atacante, final int cantidadDeSoldados, final IPais defensor) throws Exception {
        faseActual.obtenerFaseAtacar().atacar(atacante, cantidadDeSoldados, defensor);
    }

    //colocar

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
    public void siguienteFase() throws FaseIncompletaException, EjercitosException, TurnoException {
        faseActual = faseActual.siguienteFase(fabrica);
    }

    @Override
    public Mazo obtenerCanje() {
        return mazo;
    }

    @Override
    public IMapa obtenerMapa() {
        return mapa;
    }

    @Override
    public ITurno obtenerTurno() {
        return turno;
    }

	public IJugador jugadorActual() {
		return turno.jugadorActual();
	}

	public void siguienteTurno() throws TurnoException, FaseIncompletaException {
		faseActual.siguienteTurno();
		
	}

	public int cantidadDePaises() {
		return mapa.obtenerPaises().size();
	}
}