package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class EventoMostrarObjetivos implements EventHandler<ActionEvent> {

	private Juego juego;
    private VBox contenedor;
    private ContenedorJuego contenedorJuego;

    public EventoMostrarObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
	}

    @Override
    public void handle(ActionEvent event) {
        VistaObjetivos vista = new VistaObjetivos(juego, contenedor, contenedorJuego);
        vista.visualizar();
    }

}
