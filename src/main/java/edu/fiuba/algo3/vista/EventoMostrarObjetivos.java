package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class EventoMostrarObjetivos implements EventHandler<ActionEvent> {

	private Juego juego;
    private VBox contenedor;
    private ContenedorJuego contenedorJuego;
    private VistaObjetivos vista;

    public EventoMostrarObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
        this.vista = new VistaObjetivos(juego, contenedor, contenedorJuego, visualizadorFaseInicio);
	}

    @Override
    public void handle(ActionEvent event) {
        vista.visualizar();
    }

}
