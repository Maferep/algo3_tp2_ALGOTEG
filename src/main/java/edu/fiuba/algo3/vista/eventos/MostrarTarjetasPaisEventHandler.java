package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VistaTarjetasPais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MostrarTarjetasPaisEventHandler implements EventHandler<ActionEvent> {
    Juego juego;
    ContenedorJuego contenedorJuego;

    public MostrarTarjetasPaisEventHandler(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaTarjetasPais tarjetas = new VistaTarjetasPais(juego, contenedorJuego);
        tarjetas.visualizar();
    }
}
