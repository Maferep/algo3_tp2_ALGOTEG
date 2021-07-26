package edu.fiuba.algo3.modelo.fases;

import java.beans.PropertyChangeEvent;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class FaseReagrupar extends FaseAbstracta  implements IFaseReagrupar {

    IEstrategiaFase estrategia = new EstrategiaReagruparSinCompletar();
    ITurno turno;
    IMapa paises;
    private Canje canje;
    boolean finDeJuego = false;

    public FaseReagrupar(ITurno turno, IMapa paises, Canje canje) {
        this.turno = turno;
        this.mapa = paises;
        this.canje = canje;
    }

    public ITurno turno() {
        return turno;
    }

    public void transferirEjercitos(int cantidad, IPais unPais, IPais otroPais) throws TransferirEjercitosException {
        unPais.transferirEjercitosA(cantidad, otroPais);
        estrategia = estrategia.actualizar();
    }

    // métodos de fase
    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException {
        return estrategia.siguienteFase(fabrica);
    }

    @Override
    public Boolean esFinDeJuego() {
        return finDeJuego;
    }

    @Override
    public FaseReagrupar obtenerFaseReagrupar() {
        return this;
    }

}
