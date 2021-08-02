package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class EventoMostrarObjetivos implements EventHandler<ActionEvent> {
    private VistaObjetivos vista;

    public EventoMostrarObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        //TODO visualizadorFaseInicio no se usa para nada
        this.vista = new VistaObjetivos(juego, contenedor, contenedorJuego, null);
	}

    @Override
    public void handle(ActionEvent event) {
        vista.visualizar();
    }

}
