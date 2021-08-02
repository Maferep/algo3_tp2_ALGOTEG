package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class EventoMostrarObjetivos implements EventHandler<ActionEvent> {
    private VistaObjetivos vista;

    public EventoMostrarObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.vista = new VistaObjetivos(juego, contenedor, contenedorJuego);
	}

    @Override
    public void handle(ActionEvent event) {
        vista.visualizar();
    }

}
