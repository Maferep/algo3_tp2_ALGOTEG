package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonVolver implements EventHandler<ActionEvent> {
    ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;

    public BotonVolver(ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.visualizadorFaseInicio.visualizar();
    }
}
