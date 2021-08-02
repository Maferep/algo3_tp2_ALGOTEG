package edu.fiuba.algo3.modelo.Mocks;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

public class FaseInicioMock implements IFaseInicio {

    @Override
    public Boolean faseCompletada() {
        return false;
    }

    @Override
    public IFase siguienteFase(IFabricaDeFases fabrica)
            throws FaseIncompletaException, EjercitosException, TurnoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void siguienteTurno() throws TurnoException, FaseIncompletaException {
        // TODO Auto-generated method stub
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFaseInicio obtenerFaseInicio() throws FaseErroneaException {
        return this;
    }

    @Override
    public FaseAtacar obtenerFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseColocar obtenerFaseColocar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseReagrupar obtenerFaseReagrupar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int cantidadDeJugadores() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais)
            throws FichasInsuficientesException, PaisNoExistenteException, EjercitosException, FaseErroneaException {
        // TODO Auto-generated method stub

    }

    @Override
    public Mazo obtenerCanje() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IMapa obtenerMapa() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ITurno obtenerTurno() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ObjetivoManager obtenerObjetivos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ITurno turno() {
        return null;
    }

    @Override
    public IFase faseActual() {
        return null;
    }
    
}