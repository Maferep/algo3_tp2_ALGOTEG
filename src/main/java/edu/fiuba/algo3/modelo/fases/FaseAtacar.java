package edu.fiuba.algo3.modelo.fases;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseAtacar extends FaseAbstracta implements PropertyChangeListener {
    IEstrategiaFase estrategia = new EstrategiaAtaqueSinConquista();
    IMapa mapa;
    ITurno turno;
    Boolean finDeJuego = false;

    public FaseAtacar(ITurno turno, IMapa mapa) {
        this.turno = turno;
        this.mapa = mapa;
        this.turno.jugadorActual().addChangeListener(this);
    }

    public ITurno turno() {
        return turno;
    }

    // métodos públicos

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        //hacer algo porque la propiedad cambio
        //finDeJuego = (Boolean) event.getNewValue();
        finDeJuego = true;
    }

    public void atacar(IPais atacante, int cantidadDeSoldados, IPais defensor) throws Exception {
        //TODO: validar existencia de paises y turno correcto
        atacante.atacar(defensor, cantidadDeSoldados);
        atacante.obtenerConquistador().seCumplioObjetivo(); //verifico si se cumplio el objetivo del jugador cuando este ya ataco.
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
        return finDeJuego;
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
