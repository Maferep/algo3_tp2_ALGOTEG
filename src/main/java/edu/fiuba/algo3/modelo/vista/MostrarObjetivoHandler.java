package edu.fiuba.algo3.modelo.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MostrarObjetivoHandler implements EventHandler<ActionEvent> {

    private VistaObjetivos vistaObjetivos;

    public MostrarObjetivoHandler(VistaObjetivos vistaObjetivos) {
        this.vistaObjetivos = vistaObjetivos;
	}

	@Override
    public void handle(ActionEvent event) {
        vistaObjetivos.mostrarObjetivo();
    }

}
