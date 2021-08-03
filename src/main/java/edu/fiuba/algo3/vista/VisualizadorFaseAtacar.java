package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.PasajeDeFases;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;

public class VisualizadorFaseAtacar implements IVista, IVistaFases {
    Juego juego;
    ContenedorJuego contenedorJuego;

    public VisualizadorFaseAtacar(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void visualizar() {
        //TEMP para test
    }

    public void visualizarNuevaFase() {
        new VisualizadorFaseReagrupar(juego, contenedorJuego).visualizar();
    }

    public boolean esFaseInicioOColocar() {
        return false;
    }
}
