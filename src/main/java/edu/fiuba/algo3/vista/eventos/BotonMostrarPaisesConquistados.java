package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BotonMostrarPaisesConquistados implements EventHandler<ActionEvent> {

    Juego juegoActual;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseInicio;

    public BotonMostrarPaisesConquistados(Juego juego, ContenedorJuego contenedorJuego, IVista visualizadorFaseInicio) {
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
        
        TilePane lista = new TilePane(Orientation.VERTICAL);
        for(int j = 0 ; j < juegoActual.jugadorActual().obtenerPaises().size() ; j++ ) {
            Label paisesJugador = new Label();
            paisesJugador.setText(juegoActual.jugadorActual().obtenerPaises().get(j).obtenerNombre() +
                    " - " + juegoActual.jugadorActual().obtenerPaises().get(j).cantidadEjercitos() + " ejercitos");
            lista.getChildren().add(paisesJugador);
        }
        mostrarBotonVolver(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(30));
        contenedor.setBackground(
            new Background(
                new BackgroundFill(Color.KHAKI, null, null)));
        contenedor.getChildren().addAll(titulo, lista);
        this.contenedorJuego.definirSobreMapa(contenedor);
    }

    private void mostrarBotonVolver(VBox contenedor) {
        Button botonDos = new Button();
        botonDos.setText("Volver");

        contenedor.getChildren().add(botonDos);
        BotonVolver botonVolver = new BotonVolver(this.contenedorJuego, this.visualizadorFaseInicio);
        botonDos.setOnAction(botonVolver);
    }
}
