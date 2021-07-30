package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
