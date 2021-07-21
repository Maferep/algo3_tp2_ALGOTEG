package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

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
    public IFase siguienteFase(Turno turno, List<Pais> paises) throws FaseIncompletaException {
        return new FaseAtacar(turno, paises);
    }

}
