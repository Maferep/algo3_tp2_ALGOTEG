package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.fases.*;

public class FabricaDeFases {

    ITurno turno;
    IMapa mapa;
    Canje canje;

    void definirTurno(ITurno turno) {
        this.turno = turno;
    }

    void definirMapa(IMapa mapa) {
        this.mapa = mapa;
    }

    void definirCanje(Canje canje) {
        this.canje = canje;
    }

    public IFase crearFaseInicio(int cantidadDeJugadores) throws Exception {
        IFase fase = new FaseInicio(cantidadDeJugadores);

        //TODO forma rara de transferir datos. repensar.
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

    public IFase crearFaseReagruparConConquista(ITurno turno, IMapa mapa, Canje canje){
        return new FaseReagruparConConquista(turno, mapa, canje);
    }

    public IFase crearFaseReagruparConConquista() {
        return new FaseReagruparConConquista(turno, mapa, canje);
    }

    public IFase crearFaseReagruparSinConquista(ITurno turno, IMapa mapa, Canje canje) {
        return new FaseReagruparSinConquista(turno, mapa, canje);
    }

    public IFase crearFaseReagruparSinConquista() {
        return new FaseReagruparSinConquista(turno, mapa, canje);
    }

    public IFase crearFaseColocar(ITurno turno, IMapa mapa, Canje canje) throws EjercitosException {
        return new FaseColocar(turno, mapa, canje);
    }

    public IFase crearFaseColocar() throws EjercitosException {
        return new FaseColocar(turno, mapa, canje);
    }
}
