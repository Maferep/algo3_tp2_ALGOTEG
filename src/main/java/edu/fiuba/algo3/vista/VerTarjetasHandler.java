package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VerTarjetasHandler implements EventHandler<ActionEvent>{
    VistaTarjetas vista;

    ContenedorJuego contenedorJuego;
    public VerTarjetasHandler(Juego juego, ContenedorJuego contenedorJuego) {
        vista = new VistaTarjetas(juego, contenedorJuego);
    }
    @Override
    public void handle(ActionEvent event) {
        vista.visualizar(contenedorJuego);
    }

}
