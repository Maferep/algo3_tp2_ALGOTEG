package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.VisualizadorColocarEjercitosEnFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonPaisColocarEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    Juego juego;

    public BotonPaisColocarEventHandler(IPais pais, Juego juego, ContenedorJuego contenedorJuego) {
        this.pais = pais;
        this.contenedor = new VBox();
        this.contenedorJuego = contenedorJuego;
        this.juego = juego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorColocarEjercitosEnFaseInicio vistaColocarEjercitosEnPais = new VisualizadorColocarEjercitosEnFaseInicio(pais, juego, contenedorJuego);
        vistaColocarEjercitosEnPais.visualizar();
    }
}