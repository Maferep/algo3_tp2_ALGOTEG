package edu.fiuba.algo3.modelo.fases;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseColocar extends FaseAbstracta implements IFaseColocar {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();
    Boolean finDeJuego = false;

    public FaseColocar(ITurno turno, IMapa mapa, Mazo mazo) throws EjercitosException, FaseIncompletaException, TurnoException {
        this.turno = turno;
        this.mapa = mapa;
        this.mazo = mazo;
        asignarNuevosEjercitosAJugadores();
    }

    public ITurno turno() {
        return turno;
    }
    /*
        Agrega ejércitos a todos los jugadores en el turno de acuerdo con
        la regla de "la mitad de sus paises, excepto si tiene menos de 6,
        en cual caso recibe 3. No verifica la cantidad de ejércitos que
        tenían." 
    */ 
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
        if(turno.jugadorActual().cantidadEjercitosPorColocar() == 0)
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
