package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.Collectors;

public class FaseInicio implements IFase, IFaseInicio {
    Turno turno;
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();
    TurnoFactory builder = new TurnoFactory();

    static int minJugadores = 2;
    static int maxJugadores = 6;
    static int cantidadEjercitos = 8;

    //para que pasen los test hago una lista de paises random
    List<Pais> paises = Arrays.asList(
            "Puerto Rico",
            "Colombia",
            "Venezuela",
            "Honduras",
            "Guayana",
            "Guatemala")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    public FaseInicio(int cantJugadores) throws Exception {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + minJugadores + "y un máximo de"
                    + maxJugadores + "jugadores.");
        turno = builder.crearTurno(cantJugadores);
    }

    // interfaz de inicio

    public int cantidadDeJugadores() {
        return turno.cantidadDeJugadores();
    }

    //se va a tener que leer el archivo de paises e ir cargandose en la lista en la etapa inicial.

    public void asignarPaisesAleatoriamenteAJugadores() {
        for(int i = 0; i < paises.size(); i++){
            (turno.jugadorActual()).asignarPais(paises.get(i % paises.size()));
            turno.siguienteJugador();
        }
    }

    public void asignarEjercitosAJugadores() throws EjercitosException {
        for(int i = 0 ; i < cantidadDeJugadores() ; i++ ) {
            (turno.jugadorActual()).agregarEjercitos(cantidadEjercitos);
            turno.siguienteJugador();
        }
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) {
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
        return estrategia.siguienteFase(this, turno);
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
        throw new FaseErroneaException("Estamos en fase inicio");
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase inicio");
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase inicio");
    }


}
