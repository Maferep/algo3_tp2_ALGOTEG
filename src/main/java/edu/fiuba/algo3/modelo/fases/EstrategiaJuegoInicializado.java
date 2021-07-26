package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaJuegoInicializado extends EstrategiaFaseCompleta {

    @Override
    public IFase siguienteFase(ITurno turno, FabricaDeFases fabrica) throws FaseIncompletaException, TurnoException {
        verificarUltimoJugador(turno);
        return fabrica.crearFaseAtacar();
    }

}
