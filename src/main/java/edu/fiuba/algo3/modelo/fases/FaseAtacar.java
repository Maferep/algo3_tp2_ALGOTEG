package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseAtacar extends FaseAbstracta {
    IEstrategiaFase estrategia = new EstrategiaAtaqueSinConquista();
    IMapa mapa;
    ITurno turno;
    //No usa estrtegias pues puede terminar sin hacer nada

    public FaseAtacar(ITurno turno, IMapa mapa) {
        this.turno = turno;
        this.mapa = mapa;
    }

    // métodos públicos
    public void atacar(IPais atacante, int cantidadDeSoldados, IPais defensor) throws Exception {
        //TODO: validar existencia de paises y turno correcto
        atacante.atacar(defensor, cantidadDeSoldados);
        //TODO: corregir if ambiguo
        if(defensor.obtenerConquistador() == atacante.obtenerConquistador())
            estrategia = estrategia.actualizar();
    }

    public void atacarConAtaque(Ataque tipoAtaque) throws Exception {
        //TODO: validar existencia de paises y turno correcto
        tipoAtaque.atacar();
    }

    @Override
    public Boolean faseCompletada() {
        return true;
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
    public FaseAtacar obtenerFaseAtacar() throws FaseErroneaException {
        return this;
    }

    @Override
    public Objetivo obtenerObjetivo() {
        return null;
    }

}
