package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class EventoMostrarObjetivos implements EventHandler<ActionEvent> {
    private VistaObjetivos vista;


//<<<<<<< HEAD:src/main/java/edu/fiuba/algo3/vista/EventoMostrarObjetivos.java
    /*public EventoMostrarObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
        this.vista = new VistaObjetivos(juego, contenedor, contenedorJuego, visualizadorFaseInicio);*/
//=======
    public EventoMostrarObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.vista = new VistaObjetivos(juego, contenedor, contenedorJuego, visualizadorFaseInicio);
//>>>>>>> interfazMafer:src/main/java/edu/fiuba/algo3/modelo/vista/EventoMostrarObjetivos.java
	}

    @Override
    public void handle(ActionEvent event) {
        vista.visualizar();
    }

}
