package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public interface IFabricaDeFases {

    void definirTurno(ITurno turno);

    void definirMapa(IMapa mapa);

    void definirCanje(Mazo mazo);

    void definirObjetivo(ObjetivoManager objetivo);

    public IFase crearFaseInicio(int cantidadDeJugadores) throws AlgoTegException;

    public IFase crearFaseAtacar(ITurno turno, IMapa mapa);

    public IFase crearFaseAtacar();

    public IFase crearFaseReagruparConConquista(ITurno turno, IMapa mapa, Mazo mazo);

    public IFase crearFaseReagruparConConquista();

    public IFase crearFaseReagruparSinConquista(ITurno turno, IMapa mapa, Mazo mazo);

    public IFase crearFaseReagruparSinConquista();
    
    public IFase crearFaseColocar(ITurno turno, IMapa mapa, Mazo mazo)
            throws EjercitosException, FaseIncompletaException, TurnoException;

    public IFase crearFaseColocar() throws EjercitosException, FaseIncompletaException, TurnoException;
}
