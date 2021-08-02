package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverEjercitosHandler implements EventHandler<ActionEvent>{
    VistaMoverEjercitos vistaMoverEjercitos;

    public MoverEjercitosHandler(Juego juego, ContenedorJuego contenedorJuego) {
        vistaMoverEjercitos = new VistaMoverEjercitos(juego, contenedorJuego);
    }

    @Override
    public void handle(ActionEvent event) {
        vistaMoverEjercitos.visualizar();
    }

}
