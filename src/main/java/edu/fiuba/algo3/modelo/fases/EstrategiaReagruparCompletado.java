package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaReagruparCompletado extends EstrategiaFase {

    @Override
    public IFase siguienteFase(ITurno turno, FabricaDeFases fabrica) throws FaseIncompletaException,
            EjercitosException, TurnoException {
        return fabrica.crearFaseColocar();
    }
}
