package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class FaseReagrupar extends FaseAbstracta {

    IEstrategiaFase estrategia = new EstrategiaReagruparSinCompletar();

    //private Canje canje;

    public FaseReagrupar(ITurno turno, IMapa paises, Canje canje) {
        this.turno = turno;
        this.mapa = paises;
        this.canje = canje;
    }
    public void transferirEjercitos(int cantidad, IPais unPais, IPais otroPais) {
        //unPais.moverEjercitosA(otroPais); //TODO FALTA IMPLEMENTAR ADYACENCIA
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
        return false;
    }

    @Override
    public FaseReagrupar obtenerFaseReagrupar() {
        return this;
    }

}
