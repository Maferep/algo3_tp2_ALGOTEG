package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.IEstrategiaFase;
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaColocarSinCompletar implements IEstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return new EstrategiaColocarCompletado();
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }

    @Override
    public IFase siguienteFase(Turno turno, List<Pais> paises) throws FaseIncompletaException {
        // TODO Auto-generated method stub
        throw new FaseIncompletaException(null);
    }
}
