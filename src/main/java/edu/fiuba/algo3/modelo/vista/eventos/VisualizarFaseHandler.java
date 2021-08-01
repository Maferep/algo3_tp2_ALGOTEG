package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.vista.VisualizadorFase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VisualizarFaseHandler implements EventHandler<ActionEvent> {

    VisualizadorFase fase;
    public VisualizarFaseHandler(VisualizadorFase fase) {
        this.fase = fase;
    }
    @Override
    public void handle(ActionEvent event) {
        fase.visualizar();
    }
    
}