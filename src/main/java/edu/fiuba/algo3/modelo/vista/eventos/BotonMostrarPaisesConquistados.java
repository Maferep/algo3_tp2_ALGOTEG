package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BotonMostrarPaisesConquistados implements EventHandler<ActionEvent> {

    Juego juegoActual;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;

    public BotonMostrarPaisesConquistados(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juegoActual = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Label titulo = new Label();
        VBox contenedor = new VBox();
        titulo.setText("Paises conquistados");
        contenedor.getChildren().add(titulo);
        for(int j = 0 ; j < juegoActual.jugadorActual().obtenerPaises().size() ; j++ ) {
            Label paisesJugador = new Label();
            paisesJugador.setText(juegoActual.jugadorActual().obtenerPaises().get(j).obtenerNombre() +
                    " - " + juegoActual.jugadorActual().obtenerPaises().get(j).cantidadEjercitos() + " ejercitos");
            contenedor.getChildren().add(paisesJugador);
        }
        mostrarBotonVolver(contenedor);
    }

    private void mostrarBotonVolver(VBox contenedor) {
        Button botonDos = new Button();
        botonDos.setText("Volver");

        contenedor.getChildren().add(botonDos);
        BotonVolver botonVolver = new BotonVolver(this.contenedorJuego, this.visualizadorFaseInicio);
        botonDos.setOnAction(botonVolver);

        this.contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
