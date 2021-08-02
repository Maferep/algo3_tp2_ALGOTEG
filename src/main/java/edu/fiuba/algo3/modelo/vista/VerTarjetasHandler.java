package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class VerTarjetasHandler implements EventHandler<ActionEvent>{
    VistaTarjetas vista;
    public VerTarjetasHandler(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        vista = new VistaTarjetas(juego, contenedor, contenedorJuego);
    }
    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub

    }

}
