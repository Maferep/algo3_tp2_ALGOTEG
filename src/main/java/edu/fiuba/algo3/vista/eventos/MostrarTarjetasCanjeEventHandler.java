package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VistaTarjetasSimbolos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MostrarTarjetasCanjeEventHandler implements EventHandler<ActionEvent> {
    Juego juego;
    ContenedorJuego contenedorJuego;

    public MostrarTarjetasCanjeEventHandler(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaTarjetasSimbolos vista = new VistaTarjetasSimbolos(juego, contenedorJuego);
        vista.visualizar();
    }
}
