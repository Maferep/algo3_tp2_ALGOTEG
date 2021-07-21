package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaJuegoInicializado implements IEstrategiaFase {

    @Override
    public IEstrategiaFase actualizar() {
        return this;
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase(IFase actual, Turno sistemaDeTurnos) throws FaseIncompletaException {
        return new FaseAtacar(actual, sistemaDeTurnos);
    }

}
