package edu.fiuba.algo3.modelo.vista;

import javafx.scene.control.Label;

public class VistaAsignarObjetivos extends VisualizadorFase {

    ContenedorJuego contenedorJuego;
    public VistaAsignarObjetivos(ContenedorJuego contenedor)  {
        this.contenedorJuego = contenedor;
    }

    @Override
    public void visualizar() {
        //contenedorJuego.ocultarMapa();
        Label texto = new Label("La pantalla mostrará los objetivos en orden."+ 
        "El resto debe mirar a otro lado mientras se muestran.");
        contenedorJuego.getChildren().add(texto);
    }

}
