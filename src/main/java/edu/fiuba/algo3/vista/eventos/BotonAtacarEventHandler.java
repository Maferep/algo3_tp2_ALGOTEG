package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.fases.FaseAtacar;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseAtacar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
    ContenedorJuego contenedorJuego;
    Juego juego;

    public BotonAtacarEventHandler(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorFaseAtacar faseAtacar = new VisualizadorFaseAtacar(juego, contenedorJuego);
        faseAtacar.visualizar();
    }
}
