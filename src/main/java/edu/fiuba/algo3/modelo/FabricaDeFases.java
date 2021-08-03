package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

public class FabricaDeFases implements IFabricaDeFases {
    ITurno turno;
    IMapa mapa;
    Mazo mazo;
    ObjetivoManager objetivo;

    public void definirTurno(ITurno turno) {
        this.turno = turno;
    }

    public void definirMapa(IMapa mapa) {
        this.mapa = mapa;
    }

    public IFase crearFaseInicio(int cantidadDeJugadores) throws AlgoTegException {
        IFaseInicio fase;
        //si se configura algun elemento primero, lo usa
        if(turno != null || mapa != null || mazo != null || objetivo != null)
            fase = new FaseInicio(mapa, turno, mazo, objetivo);
        else fase = new FaseInicio(cantidadDeJugadores);

        definirCanje(fase.obtenerCanje());
        definirMapa(fase.obtenerMapa());
        definirTurno(fase.obtenerTurno());
        definirObjetivo(fase.obtenerObjetivos());

        return fase;
    }

    public IFase crearFaseAtacar(ITurno turno, IMapa mapa) {
        return new FaseAtacar(turno, mapa);
    }

    public IFase crearFaseAtacar() {
        return new FaseAtacar(turno, mapa);
    }

    public IFase crearFaseReagruparConConquista() {
        return new FaseReagruparConConquista(turno, mapa, mazo);
    }

    public IFase crearFaseReagruparSinConquista() {
        return new FaseReagruparSinConquista(turno, mapa, mazo);
    }

    public IFase crearFaseColocar(ITurno turno, IMapa mapa, Mazo mazo)
            throws EjercitosException, FaseIncompletaException, TurnoException {
        return new FaseColocar(turno, mapa, mazo);
    }

    public IFase crearFaseColocar() throws EjercitosException, FaseIncompletaException, TurnoException {
        return new FaseColocar(turno, mapa, mazo);
    }

    @Override
    public void definirCanje(Mazo mazo) {
        this.mazo = mazo;

    }

    @Override
    public void definirObjetivo(ObjetivoManager objetivo) {
        this.objetivo = objetivo;

    }

    @Override
    public IFase crearFaseReagruparConConquista(ITurno turno, IMapa mapa, Mazo mazo) {
        return new FaseReagruparConConquista(turno, mapa, mazo);
    }

    @Override
    public IFase crearFaseReagruparSinConquista(ITurno turno, IMapa mapa, Mazo mazo) {
        return new FaseReagruparSinConquista(turno, mapa, mazo);
    }
}