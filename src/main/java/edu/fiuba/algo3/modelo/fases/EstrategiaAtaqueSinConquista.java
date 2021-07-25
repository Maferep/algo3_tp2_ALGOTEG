package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaAtaqueSinConquista extends EstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return new EstrategiaAtaqueConConquista();
    }

    @Override
    public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException {
        return fabrica.crearFaseReagruparSinConquista();
    }
}
