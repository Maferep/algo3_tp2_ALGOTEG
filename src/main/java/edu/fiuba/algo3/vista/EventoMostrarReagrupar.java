package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventoMostrarReagrupar implements EventHandler<ActionEvent> {
    private VistaReagrupar vista;
    private ContenedorJuego contenedor;

    public EventoMostrarReagrupar(Juego juego,  ContenedorJuego contenedorJuego) {
        this.vista = new VistaReagrupar(juego, contenedorJuego);
        this.contenedor = contenedorJuego;
	}

    @Override
    public void handle(ActionEvent event) {
        vista.visualizar();
    }

}
