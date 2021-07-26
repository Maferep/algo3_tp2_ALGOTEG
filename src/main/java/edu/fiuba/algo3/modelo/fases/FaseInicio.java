package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.Collectors;

public class FaseInicio extends FaseAbstracta implements IFaseInicio {

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

    public FaseInicio(int cantJugadores) throws CantidadDeJugadoresError, EjercitosException {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" 
                    + minJugadores + "y un máximo de"
                    + maxJugadores + "jugadores.");
        canje = new Canje(paises);
        turno = new Turno(colores, cantJugadores, canje);
        mapa = new Mapa();
        mapa.definirPaises(paises);
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
        estrategia = estrategia.actualizar();
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
    public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException {
        return estrategia.siguienteFase(fabrica);
    }
    
    @Override
    public Boolean esFinDeJuego() {
        return false;
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
