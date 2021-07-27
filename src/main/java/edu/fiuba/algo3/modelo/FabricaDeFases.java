package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;
import edu.fiuba.algo3.modelo.fases.*;

import java.util.List;

public class FabricaDeFases {
    ITurno turno;
    IMapa mapa;
    ObjetivoManager objetivo;
    Mazo mazo;

    void definirTurno(ITurno turno) {
        this.turno = turno;
    }

    void definirMapa(IMapa mapa) {
        this.mapa = mapa;
    }

    void definirCanje(Mazo mazo) {
        this.mazo = mazo;
    }

    void definirObjetivo(ObjetivoManager objetivo) { this.objetivo = objetivo;}

    public IFase crearFaseInicio(int cantidadDeJugadores) throws Exception {
        IFase fase = new FaseInicio(cantidadDeJugadores);

        // TODO forma rara de transferir datos. repensar.
        definirCanje(fase.obtenerFaseInicio().obtenerCanje());
        definirMapa(fase.obtenerFaseInicio().obtenerMapa());
        definirTurno(fase.obtenerFaseInicio().obtenerTurno());

        return fase;
    }

    public IFase crearFaseAtacar(ITurno turno, IMapa mapa) {
        return new FaseAtacar(turno, mapa);
    }

    public IFase crearFaseAtacar() {
        return new FaseAtacar(turno, mapa);
    }
/*
<<<<<<< HEAD
    public IFase crearFaseReagruparConConquista(ITurno turno, IMapa mapa, Canje canje) {
        return new FaseReagruparConConquista(turno, mapa, canje);
=======*/
    public IFase crearFaseReagruparConConquista(ITurno turno, IMapa mapa, Mazo mazo){
        return new FaseReagruparConConquista(turno, mapa, mazo);
//>>>>>>> canjes
    }

    public IFase crearFaseReagruparConConquista() {
        return new FaseReagruparConConquista(turno, mapa, mazo);
    }

    public IFase crearFaseReagruparSinConquista(ITurno turno, IMapa mapa, Mazo mazo) {
        return new FaseReagruparSinConquista(turno, mapa, mazo);
    }

    public IFase crearFaseReagruparSinConquista() {
        return new FaseReagruparSinConquista(turno, mapa, mazo);
    }

//<<<<<<< HEAD
    /*public IFase crearFaseColocar(ITurno turno, IMapa mapa, Canje canje)
            throws EjercitosException, TurnoException, FaseIncompletaException {
        return new FaseColocar(turno, mapa, canje);
    }*/

  /*  public IFase crearFaseColocar()
            throws EjercitosException, TurnoException, FaseIncompletaException {
        return new FaseColocar(turno, mapa, canje);
=======*/
    public IFase crearFaseColocar(ITurno turno, IMapa mapa, Mazo mazo) throws EjercitosException, FaseIncompletaException, TurnoException {
        return new FaseColocar(turno, mapa, mazo);
    }

    public IFase crearFaseColocar() throws EjercitosException, FaseIncompletaException, TurnoException {
        return new FaseColocar(turno, mapa, mazo);
//>>>>>>> canjes
    }
}
