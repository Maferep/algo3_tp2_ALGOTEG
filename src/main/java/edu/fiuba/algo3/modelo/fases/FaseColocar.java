package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseColocar extends FaseAbstracta {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();
    ITurno turno;
    List<Pais> paises;

    public FaseColocar(ITurno turno2, List<Pais> paises) {
        this.turno = turno2;
        this.paises = paises;
	}

	public void asignarNuevosEjercitosAJugadores() throws EjercitosException {
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++ ) {
            //TODO: accede a paises del jugador directamente, puede que viole tda
            (turno.jugadorActual()).agregarNuevosEjercitos(((turno.jugadorActual().paises.size())/2));
            turno.siguienteJugador();
        }
        turno.siguienteJugador();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError {
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
        return estrategia.siguienteFase(turno, paises);
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
