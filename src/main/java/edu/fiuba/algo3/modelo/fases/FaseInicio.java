package edu.fiuba.algo3.modelo.fases;

import java.beans.PropertyChangeEvent;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.Collectors;

public class FaseInicio extends FaseAbstracta implements IFaseInicio {
    ObjetivoManager objetivo;
    FabricaDeObjetivos fabricaObjetivos;
    Boolean finDeJuego = false;

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
    List<IPais> paises;

    public FaseInicio(int cantJugadores) throws CantidadDeJugadoresError, EjercitosException, ObjetivoException {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de "
                    + minJugadores + " y un máximo de "
                    + maxJugadores + " jugadores.");
        turno = new Turno(colores, cantJugadores);
        fabricaObjetivos = new FabricaDeObjetivos(turno, mapa);
        objetivo = new ObjetivoManager(turno, fabricaObjetivos.crearObjetivos());
        canje = new Canje(paises);
        mapa = new Mapa();
        paises = mapa.obtenerPaises();
        canje = new Canje(paises);
    }

    public ITurno turno() {
        return turno;
    }
    //version para mock
    public FaseInicio(IMapa mapa, ITurno turno, Canje canje)  {
        this.turno = turno;
        this.mapa = mapa;
        this.canje = canje;
    }

    // interfaz de inicio

    public int cantidadDeJugadores() {
        return turno.cantidadDeJugadores();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) throws FichasInsuficientesError, PaisNoExistenteError,
            EjercitosException {
        turno.jugadorActual().agregarEjercitosAPais(pais, cantEjercitos);
        estrategia = estrategia.turnoCompleto(turno);
    }

    // lógica interna

    private Boolean validarCantidad(int cant) {
        return (cant >= minJugadores && cant <= maxJugadores);
    }

    // métodos de fase

    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException,
            TurnoException {
        return estrategia.siguienteFase(turno, fabrica);
    }
    
    @Override
    public Boolean esFinDeJuego() {
        return finDeJuego;
    }
    
    @Override
    public FaseInicio obtenerFaseInicio() {
        return this;
    }

    @Override
	public Canje obtenerCanje() {
		return canje;
	}

    @Override
	public IMapa obtenerMapa() {
		return mapa;
	}

    @Override
	public ITurno obtenerTurno() {
		return turno;
	}
}
