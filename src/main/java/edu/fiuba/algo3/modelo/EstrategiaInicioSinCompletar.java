package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaInicioSinCompletar implements IEstrategiaFase {

    @Override
    public IEstrategiaFase actualizar() {
        return new EstrategiaJuegoInicializado();
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }

    @Override
    public IFase siguienteFase(Turno turno, List<Pais> paises) throws FaseIncompletaException{
        throw new FaseIncompletaException(null);
    }
}
