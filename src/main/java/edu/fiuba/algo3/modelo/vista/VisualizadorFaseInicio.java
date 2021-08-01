package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;
import java.util.List;

public class VisualizadorFaseInicio {
    VBox contenedor;
    Juego juego;
    int cantidadDeJugadores;

    public VisualizadorFaseInicio(int cantidadJugadores, ContenedorJuego contenedor) throws Exception {
        this.contenedor = contenedor.obtenerBotonera();
        this.cantidadDeJugadores = cantidadJugadores;
    }

    //TODO obtener lista de colores y mostrarla a los jugadores
    public void visualizar() {
        try {
            juego = crearJuego(this.cantidadDeJugadores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 1;

        //solo para mostrar que funciona
        List<Color> coloresParaJugadores =  Arrays.asList(
                Color.web("#0000FF",1.0),
                Color.web("#DC143C",1.0),
                Color.web("#FFD700",1.0),
                Color.web("#008000",1.0),
                Color.web("#FF69B4",1.0),
                Color.web("#000000",1.0)
        );

        while(i <= this.cantidadDeJugadores) {
            Label texto = new Label();
            javafx.scene.image.Image imagen = new Image("file:src/main/resources/fondoBlanco.jpeg");
            BackgroundImage imagenDeFondo= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            texto.setText("Jugador " + i + ":" + juego.obtenerFaseActual().turno().jugadorActual().obtenerColor()) ;
            texto.setTextFill(coloresParaJugadores.get(i-1));
            texto.setMinWidth(10);
            texto.setMinSize(10,10);
            texto.setBackground(new Background(imagenDeFondo));
            texto.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));
            contenedor.getChildren().add(texto);
            i++;
            juego.obtenerFaseActual().turno().siguienteJugador();
        }

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);
    }

    private Juego crearJuego(int cantidadJugadores) throws Exception {
        Juego juego = new Juego(cantidadJugadores);
        return juego;
    }

}