package edu.fiuba.algo3.modelo.Mocks;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.FaseInicio;

public class FabricaDeFasesMock implements IFabricaDeFases {
    ITurno turno;
    ObjetivoManager objetivo;

    @Override
    public void definirTurno(ITurno turno) {
        this.turno = turno;

    }

    @Override
    public void definirMapa(IMapa mapa) {
        // TODO Auto-generated method stub

    }

    @Override
    public void definirCanje(Mazo mazo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void definirObjetivo(ObjetivoManager objetivo) {
        this.objetivo = objetivo;

    }

    @Override
    public IFase crearFaseInicio(int cantidadDeJugadores) throws AlgoTegException {
        return new FaseInicio(
            new MapaMock(null), 
            turno, 
            null, 
            objetivo);
    }

    @Override
    public IFase crearFaseAtacar(ITurno turno, IMapa mapa) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseAtacar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseReagruparConConquista(ITurno turno, IMapa mapa, Mazo mazo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseReagruparConConquista() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseReagruparSinConquista(ITurno turno, IMapa mapa, Mazo mazo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseReagruparSinConquista() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseColocar(ITurno turno, IMapa mapa, Mazo mazo)
            throws EjercitosException, FaseIncompletaException, TurnoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase crearFaseColocar() throws EjercitosException, FaseIncompletaException, TurnoException {
        // TODO Auto-generated method stub
        return null;
    }
    
}