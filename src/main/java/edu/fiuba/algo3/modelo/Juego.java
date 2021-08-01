package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class Juego implements  PropertyChangeListener {
    //TODO reemplazar por estrategia
    Boolean juegoTerminado = false;
    
    IFase faseActual;
    IFabricaDeFases fabrica = new FabricaDeFases();

    IMapa mapa;
    ITurno turno;
    Mazo mazo;
    ObjetivoManager objetivos;

    public Juego(final int cantidadDeJugadores) throws Exception {
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);

        mapa = faseActual.obtenerFaseInicio().obtenerMapa();
        turno = faseActual.obtenerFaseInicio().obtenerTurno();
        mazo = faseActual.obtenerFaseInicio().obtenerCanje();
        objetivos = faseActual.obtenerFaseInicio().obtenerObjetivos();
        objetivos.agregarSuscriptorAVictoria(this);
    }

    public Juego(IFabricaDeFases fabrica, int cantidadDeJugadores) throws Exception {
        this.fabrica = fabrica;
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);

        mapa = faseActual.obtenerFaseInicio().obtenerMapa();
        turno = faseActual.obtenerFaseInicio().obtenerTurno();
        mazo = faseActual.obtenerFaseInicio().obtenerCanje();
        objetivos = faseActual.obtenerFaseInicio().obtenerObjetivos();
        objetivos.agregarSuscriptorAVictoria(this);
    }

    public IFase obtenerFaseActual() {
        return this.faseActual.faseActual();
    }

    // inicio

    
    public void ubicarEjercitosEnPais(final int cantEjercitos, final IPais pais)
            throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException, FaseErroneaException {
        faseActual.obtenerFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    // reagrupar

    
    public void transferirEjercitos(int cantidad, IPais unPais, IPais otroPais)
            throws FaseErroneaException, TransferirEjercitosException {
        faseActual.obtenerFaseReagrupar().transferirEjercitos(cantidad, unPais, otroPais);
    }

    // atacar

    
    public void atacar(final IPais atacante, final int cantidadDeSoldados, final IPais defensor) throws Exception {
        faseActual.obtenerFaseAtacar().atacar(atacante, cantidadDeSoldados, defensor);
    }

    // colocar

    
    public void colocarEjercitosEnPais(final int cantEjercitos, final IPais pais)
            throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError, FaseErroneaException {
        faseActual.obtenerFaseColocar().colocarEjercitosEnPais(cantEjercitos, pais);
    }

    // datos persistentes del juego

    public int cantidadDeJugadores() {
        return turno.cantidadDeJugadores();
    }

    // avanzar fase
    public void siguienteFase() throws FaseIncompletaException, EjercitosException, TurnoException {
        faseActual = faseActual.siguienteFase(fabrica);
    }

    
    public Mazo obtenerCanje() {
        return mazo;
    }

    
    public IMapa obtenerMapa() {
        return mapa;
    }

    /*
        Obtiene los nombres de los colores de cada jugador existente en orden, 
        empezando por el jugador actual.
    */
    public List<String> obtenerNombresDeColores() {
        return turno.obtenerColores();
    }

    public IJugador jugadorActual() {
        return turno.jugadorActual();
    }

    public void siguienteTurno() throws TurnoException, FaseIncompletaException {
        faseActual.siguienteTurno();

    }

    public int cantidadDePaises() {
        return mapa.obtenerPaises().size();
    }
    
    public void propertyChange(PropertyChangeEvent evento) {
        //TODO cambiar a estrategia 'juego completado'
        //y buscar el ganador
        juegoTerminado = true;
    }
}