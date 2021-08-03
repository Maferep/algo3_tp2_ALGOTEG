package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonVolver implements EventHandler<ActionEvent> {
    ContenedorJuego contenedorJuego;
    IVista visualizadorRequerido;

    public BotonVolver(ContenedorJuego contenedorJuego, IVista visualizadorRequerido) {
        this.contenedorJuego = contenedorJuego;
        this.visualizadorRequerido = visualizadorRequerido;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.visualizadorRequerido.visualizar();
    }
}
