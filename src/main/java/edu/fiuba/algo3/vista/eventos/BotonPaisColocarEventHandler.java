package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonPaisColocarEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    VBox contenedor;
    ContenedorJuego contenedorJuego;

    public BotonPaisColocarEventHandler(IPais pais, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.pais = pais;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
