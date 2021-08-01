package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BotonMostrarPaisesConquistados implements EventHandler<ActionEvent> {

    Juego juegoActual;
    VBox contenedor;
    ContenedorJuego contenedorJuego;

    public BotonMostrarPaisesConquistados(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.juegoActual = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Label titulo = new Label();
        VBox contenedor = new VBox();
        titulo.setText("Paises conquistados");
        contenedor.getChildren().add(titulo);
        for(int j = 0 ; j < juegoActual.jugadorActual().obtenerPaises().size() ; j++ ) {
            Label paisesJugador = new Label();
            paisesJugador.setText(juegoActual.jugadorActual().obtenerPaises().get(j).obtenerNombre());
            contenedor.getChildren().add(paisesJugador);
        }
        this.contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        /*Button boton = new Button();
        boton.setText("Volver");

        this.contenedor.getChildren().add(boton);

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        BotonVolver botonVolver = new BotonVolver();
        boton.setOnAction(botonVolver);*/

        //BotonVolver botonVolver = new BotonVolver(this.contenedor, this.contenedorJuego);
        //boton.setOnAction(botonVolver);
    }
}
