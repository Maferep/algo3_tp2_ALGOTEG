package edu.fiuba.algo3.vista.interfases;

import edu.fiuba.algo3.modelo.excepciones.AlgoTegException;

public interface IVistaFases extends IVista{
    /*d
    * Implementada por:
    * VisualizadorFaseInicio
    * VisualizadorFaseAtacar
    * VisualizadorFaseReagrupar
    * VisualizadorFaseColocar
    * */
    public void visualizarNuevaFase();
    public void visualizarJuegoTerminado() throws AlgoTegException;
}
