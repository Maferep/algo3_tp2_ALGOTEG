package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;

public class FaseInicio implements IFase, IFaseInicio {
    List<Pais> paises;
    Turno turno;
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();
    TurnoFactory factory = new TurnoFactory();

    static int minJugadores = 2;
    static int maxJugadores = 6;

    public FaseInicio(int cantJugadores) throws Exception {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + minJugadores + "y un máximo de"
                    + maxJugadores + "jugadores.");
        turno = factory.crearTurno(cantJugadores);
    }

    // interfaz de inicio

    public int cantidadDeJugadores() {
        return turno.cantidadDeJugadores();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) {
        // TODO ubicarEjercitos
        //al 'terminar de ubicar' la etapa inicial se considera completada
        estrategia = estrategia.actualizar();
    }

    // lógica interna

    private Boolean validarCantidad(int cant) {
        return (cant >= minJugadores && cant <= maxJugadores);
    }

    // métodos de fase
    //TODO: heredar de Fase abstracta en lugar de interfaz

    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        return estrategia.siguienteFase(this);
    }
    
    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public FaseInicio asFaseInicio() {
        return this;
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }


}
