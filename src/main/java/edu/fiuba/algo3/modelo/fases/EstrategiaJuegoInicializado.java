package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaJuegoInicializado extends EstrategiaFase {

    @Override
    public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException {
        return fabrica.crearFaseAtacar();
    }

}
