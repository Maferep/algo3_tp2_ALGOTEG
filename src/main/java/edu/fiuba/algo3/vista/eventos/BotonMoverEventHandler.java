package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private final VistaJuego vista;
    private final Juego juego;

    public BotonMoverEventHandler(VistaJuego vista, Juego juego) {
        this.vista =  vista;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //this.juego.mover();
        this.vista.update();
    }

}
