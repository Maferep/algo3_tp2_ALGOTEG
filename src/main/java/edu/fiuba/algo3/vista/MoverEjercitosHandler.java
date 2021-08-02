package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class MoverEjercitosHandler implements EventHandler<ActionEvent>{
    VistaMoverEjercitos vistaMoverEjercitos;

    public MoverEjercitosHandler(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        vistaMoverEjercitos = new VistaMoverEjercitos(juego, contenedor, contenedorJuego);
    }

    @Override
    public void handle(ActionEvent event) {
        vistaMoverEjercitos.visualizar();
    }

}
