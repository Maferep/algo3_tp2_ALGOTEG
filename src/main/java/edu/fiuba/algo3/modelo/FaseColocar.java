package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseAtacar;
import edu.fiuba.algo3.modelo.FaseInicio;
import edu.fiuba.algo3.modelo.Interfaces.IEstrategiaFase;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.IFase;

public class FaseColocar implements IFase {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();
    Turno turno;
    public FaseColocar(IFase faseAnterior, Turno sistemaDeTurnos) {
        turno = sistemaDeTurnos;
    }

    public void asignarNuevosEjercitosAJugadores() throws EjercitosException {
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++ ) {
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
        // TODO Auto-generated method stub
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        // TODO Auto-generated method stub
        return estrategia.siguienteFase(this, turno);
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase colocar");
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase colocar");
    }

    @Override
    public FaseColocar asFaseColocar() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase colocar");
    }

}
