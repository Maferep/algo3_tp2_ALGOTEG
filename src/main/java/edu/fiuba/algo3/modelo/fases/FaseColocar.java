package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseColocar extends FaseAbstracta implements IFaseColocar, ITurno {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();
    IMapa mapa;

    public FaseColocar(ITurno turno, IMapa mapa, Canje canje) throws EjercitosException {
        this.turno = turno;
        this.mapa = mapa;
        this.canje = canje;
        asignarNuevosEjercitosAJugadores();
    }
    
	public void asignarNuevosEjercitosAJugadores() throws EjercitosException {
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
    public FaseColocar obtenerFaseColocar() {
        return this;
    }

    @Override
    public IJugador jugadorActual() {
        return turno.jugadorActual();
    }

    @Override
    public void siguienteJugador() {
        estrategia.siguienteJugador();
        estrategia = estrategia.actualizar();
    }

    @Override
    public int cantidadDeJugadores() {
        // TODO Auto-generated method stub
        return 0;
    }
}
