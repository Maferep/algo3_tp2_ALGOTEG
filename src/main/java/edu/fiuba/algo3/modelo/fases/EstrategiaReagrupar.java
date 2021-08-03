package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;


public class EstrategiaReagrupar extends EstrategiaFaseCompleta {
    @Override
    public IEstrategiaFase turnoCompleto(ITurno turno) {
        return this;
    }

    //TODO PRUEBA: Anda!!!!!!!!
    @Override
    public IFase siguienteFase(ITurno turno, IFabricaDeFases fabrica) throws FaseIncompletaException, TurnoException, EjercitosException {
        verificarUltimoJugador(turno);
        return fabrica.crearFaseColocar();
    }
}
