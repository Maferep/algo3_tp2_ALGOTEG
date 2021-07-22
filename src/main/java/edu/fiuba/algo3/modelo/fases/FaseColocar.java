package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseColocar extends FaseAbstracta {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();
    ITurno turno;
    List<IPais> paises;
    Canje canje;

    public FaseColocar(ITurno turno2, List<IPais> paises, Canje canje) {
        this.turno = turno2;
        this.paises = paises;
        this.canje = canje;
	}

	public void asignarNuevosEjercitosAJugadores() throws EjercitosException {
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++ ) {
            //TODO: accede a paises del jugador directamente, puede que viole tda
            (turno.jugadorActual()).agregarNuevosEjercitos(((turno.jugadorActual().obtenerPaises().size())/2));
            turno.siguienteJugador();
        }
        turno.siguienteJugador();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError {
        asignarNuevosEjercitosAJugadores();
        turno.jugadorActual().verificarCantidadDeEjercitos(cantEjercitos);
        turno.jugadorActual().verificarPais(pais);
        pais.agregarEjercitos(cantEjercitos);
        estrategia = estrategia.actualizar();
    }

    // métodos de fase
    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        return estrategia.siguienteFase(turno, paises, canje);
    }

    @Override
    public Boolean esFinDeJuego() {
        return false;
    }

    @Override
    public FaseColocar asFaseColocar() {
        return this;
    }
}
