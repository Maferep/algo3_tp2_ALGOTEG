package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaJuegoInicializado implements IEstrategiaFase {

    @Override
    public IEstrategiaFase actualizar() throws Exception {
        throw new Exception();
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase(IFase actual) throws FaseIncompletaException {
        return new FaseAtacar(actual);
    }

}
