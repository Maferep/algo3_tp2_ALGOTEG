package edu.fiuba.algo3.modelo.fases;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseColocar extends FaseAbstracta implements IFaseColocar {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();
    Boolean finDeJuego = false;
/*
<<<<<<< HEAD
    public FaseColocar(ITurno turno, IMapa mapa, Canje canje) throws EjercitosException, TurnoException,
            FaseIncompletaException {
=======*/
    public FaseColocar(ITurno turno, IMapa mapa, Mazo mazo) throws EjercitosException, FaseIncompletaException, TurnoException {
//>>>>>>> canjes
        this.turno = turno;
        this.mapa = mapa;
        this.mazo = mazo;
        asignarNuevosEjercitosAJugadores();
    }

    public ITurno turno() {
        return turno;
    }
    
	private void asignarNuevosEjercitosAJugadores() throws EjercitosException, TurnoException, FaseIncompletaException {
        for(int i = 0 ; i < turno.cantidadDeJugadores() ; i++ ) {
            int cantidadDeSoldados = 
                Math.max( turno.jugadorActual().cantidadPaises()/2, 3);
            turno.jugadorActual().agregarNuevosEjercitos(cantidadDeSoldados);
            turno.siguienteJugador();
        }
    }

    public void colocarEjercitosEnPais(int cantEjercitos, IPais pais) throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError {
        turno.jugadorActual().agregarEjercitosAPais(pais, cantEjercitos);
        if(turno.jugadorActual().cantidadEjercitos() == 0)
            //current plyer finished task
             estrategia = estrategia.turnoCompleto(turno);
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
    public FaseColocar obtenerFaseColocar() {
        return this;
    }

    public IJugador jugadorActual() {
        return turno.jugadorActual();
    }

    public void siguienteJugador() throws TurnoException, FaseIncompletaException {
        estrategia.siguienteJugador(turno);
    }

    public int cantidadDeJugadores() {
        return turno.cantidadDeJugadores();
    }
}
