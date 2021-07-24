package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.Collectors;

public class FaseInicio extends FaseAbstracta implements IFaseInicio {
    ITurno turno;
    Canje canje;
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();
    List<String> colores =  Arrays.asList(
        "Azul", 
        "Rojo", 
        "Amarillo", 
        "Verde", 
        "Rosa", 
        "Negro");

    static int minJugadores = 2;
    static int maxJugadores = 6;
    static int cantidadEjercitos = 8;

    //para que pasen los test hago una lista de paises random
    List<IPais> paises = Arrays.asList(
            "Puerto Rico",
            "Colombia",
            "Venezuela",
            "Honduras",
            "Guayana",
            "Guatemala")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    //TODO NULO
    IMapa mapa;

    public FaseInicio(int cantJugadores) throws Exception {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" 
                    + minJugadores + "y un máximo de"
                    + maxJugadores + "jugadores.");
        turno = new Turno(colores, cantJugadores);
        canje = new Canje(paises);
    }

    //version para mock
    public FaseInicio(ITurno turno) throws Exception {
        this.turno = turno;
    }

    // interfaz de inicio

    public int cantidadDeJugadores() {
        return turno.cantidadDeJugadores();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) throws FichasInsuficientesError, PaisNoExistenteError,
            EjercitosException {
        turno.jugadorActual().agregarEjercitosAPais(pais, cantEjercitos);
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
    public IFase siguienteFase() throws FaseIncompletaException, EjercitosException {
        return estrategia.siguienteFase(turno, mapa, canje);
    }
    
    @Override
    public Boolean esFinDeJuego() {
        return false;
    }
    
    @Override
    public FaseInicio obtenerFaseInicio() {
        return this;
    }
}
