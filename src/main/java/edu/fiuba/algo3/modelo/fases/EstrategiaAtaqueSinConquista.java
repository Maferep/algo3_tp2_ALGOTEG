package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaAtaqueSinConquista extends EstrategiaFaseCompleta {
    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return new EstrategiaAtaqueConConquista();
    }

    @Override
    public IFase siguienteFase(ITurno turno, FabricaDeFases fabrica) throws FaseIncompletaException, TurnoException {
        if(!turno.esUltimoJugador())
            throw new TurnoException(null);
        return fabrica.crearFaseReagruparSinConquista();
    }
}
