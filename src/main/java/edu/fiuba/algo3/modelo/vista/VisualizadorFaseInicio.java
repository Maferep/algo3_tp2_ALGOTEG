package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.eventos.BotonComenzarJuegoEventHandler;
import edu.fiuba.algo3.modelo.vista.eventos.BotonMostrarPaisesConquistados;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    ContenedorJuego contenedorJuego;

    static String ARCHIVO_FONDO = "file:src/main/resources/fondoBlanco.jpeg";

    List<Color> coloresParaJugadores =  Arrays.asList(
            Color.web("#0000FF",1.0),
            Color.web("#DC143C",1.0),
            Color.web("#FFD700",1.0),
            Color.web("#008000",1.0),
            Color.web("#FF69B4",1.0),
            Color.web("#000000",1.0)
    );

    public VisualizadorFaseInicio(int cantidadJugadores, VBox contenedor, ContenedorJuego contenedorJuego) throws Exception {
        this.contenedor = contenedor;
        this.cantidadDeJugadores = cantidadJugadores;
        this.contenedorJuego = contenedorJuego;
    }

    //TODO obtener lista de colores y mostrarla a los jugadores
    public void visualizar() {
        try {
            juego = crearJuego(this.cantidadDeJugadores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0; i < juego.cantidadDeJugadores(); i++)
            imprimirJugador("Jugador " + (i+1) + ":" + juego.obtenerNombresDeColores().get(i));

        /*
        * Mostrar los jugadores uno por uno. Cuando termina uno sigue el otro y asi.
        * Luego paso a la fase de ataque
        */

        this.mostrarPaisesConquistados();

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);
    }

    private void imprimirJugador(String texto) {
        Label nombreJugador = new Label();
        javafx.scene.image.Image imagen = new Image(ARCHIVO_FONDO);
        BackgroundImage imagenDeFondo= new BackgroundImage(
            imagen, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            BackgroundSize.DEFAULT);
        nombreJugador.setText(texto);
        nombreJugador.setTextFill(coloresParaJugadores.get(0));
        nombreJugador.setMinWidth(10);
        nombreJugador.setMinSize(10,10);
        nombreJugador.setBackground(new Background(imagenDeFondo));
        nombreJugador.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));
        contenedor.getChildren().add(nombreJugador);
    }

    private Juego crearJuego(int cantidadJugadores) throws Exception {
        Juego juego = new Juego(cantidadJugadores);
        return juego;
    }

    private void mostrarPaisesConquistados() {
        Button boton = new Button();
        boton.setText("Mostrar paises conquistados");

        contenedor.getChildren().add(boton);

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        BotonMostrarPaisesConquistados botonMostrarPaisesConquistados 
            = new BotonMostrarPaisesConquistados(
                juego,this.contenedor, 
                this.contenedorJuego);
        boton.setOnAction(botonMostrarPaisesConquistados);

    }

}