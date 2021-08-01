package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.eventos.BotonComenzarJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorRealizaJuego extends BorderPane {
    private Juego juego;
    int numeroJugadores = 3;
    Stage stage;
    BarraDeMenu menuBar;
    VBox contenedor = new VBox();

    public ContenedorRealizaJuego(Stage stage) {
        super();
        this.stage = stage;
        this.setMenu(stage);
        this.setCentro();
        this.setConsola();
        this.setBotonera();
        this.comenzarJuego();
    }

    private void setBotonera() {
        //ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
        Label texto = new Label();
        texto.setText("Pais a atacar");

        Button boton = new Button();
        boton.setText("Atacar");

        // VBox contenedor = new VBox(tablero, texto, campo, boton);

        VBox contenedor = new VBox(texto,boton);

        //this.contenedor.getChildren().addAll(texto,boton);

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        //BotonComenzarJuegoEventHandler botonEnviarEventHandler = new BotonComenzarJuegoEventHandler(stage, proximaEscena, campo, texto, this, this.proximoContenedor);
        //boton.setOnAction(botonEnviarEventHandler); crear boton para que se ataque

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        this.setRight(contenedor);
        this.setStyle("-fx-background-color: rgba(243,177,64,0.51);");
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        Image imagen = new Image("file:src/main/resources/vintageopciontres.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);

        ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
        VBox contenedor = new VBox(tablero);
        StackPane ruta = new StackPane();

        contenedor.setBackground(new Background(imagenDeFondo));

        ruta.getChildren().addAll(contenedor);

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        this.setCenter(contenedor);
    }

    private void setConsola() {
        Label etiqueta = new Label();
        etiqueta.setText("ALGOTEG - TODOS LOS DERECHOS RESERVADOS");
        etiqueta.setFont(Font.font("Courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.BLACK);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }


    private void comenzarJuego() {
        int i = 1;

        try {
            juego = crearJuego(numeroJugadores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        VBox contenedor = new VBox();
        //juego.obtenerFaseActual().turno().cantidadDeJugadores()
        while(i <= 3 ) {
            Label texto = new Label();
            javafx.scene.image.Image imagen = new Image("file:src/main/resources/fondoBlanco.jpeg");
            BackgroundImage imagenDeFondo= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            texto.setText("Jugador " + i + ":" + juego.obtenerFaseActual().turno().jugadorActual().obtenerColor()) ;
            texto.setTextFill(javafx.scene.paint.Color.BLACK);
            texto.setMinWidth(10);
            texto.setMinSize(10,10);
            texto.setBackground(new Background(imagenDeFondo));
            texto.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));
            contenedor.getChildren().add(texto);
            i++;
            juego.obtenerFaseActual().turno().siguienteJugador();
        }
        StackPane ruta = new StackPane();
        ruta.getChildren().addAll(contenedor);
        this.setRight(contenedor);
    }

    private Juego crearJuego(int cantidadJugadores) throws Exception {
        Juego juego = new Juego(cantidadJugadores);
        return juego;
    }

    public void asignarCantidadJugadores(int numero) {
        this.numeroJugadores = numero;
    }
}
