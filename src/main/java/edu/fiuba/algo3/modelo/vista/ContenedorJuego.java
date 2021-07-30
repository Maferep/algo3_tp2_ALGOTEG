package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.vista.eventos.BotonComenzarJuegoEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.eventos.BotonMoverEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.Objects;

public class ContenedorJuego extends BorderPane {

    BarraDeMenu menuBar;
    VistaJuego vistaJuego;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorJuego(Stage stage, Juego juego) {
        this.setMenu(stage);
        this.setCentro(juego);
        this.setConsola();
        this.setBotonera(juego);
        //this.setTablero(stage);
    }

    private void setBotonera(Juego juego) {
        //ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
        Label texto = new Label();
        texto.setText("Ingrese cantidad de jugadores");

        TextField campo = new TextField();

        Button boton = new Button();
        boton.setText("Empezar juego");

       // VBox contenedor = new VBox(tablero, texto, campo, boton);

        VBox contenedor = new VBox(texto,campo,boton);

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        BotonComenzarJuegoEventHandler botonEnviarEventHandler = new BotonComenzarJuegoEventHandler(campo, texto);
        boton.setOnAction(botonEnviarEventHandler);

        Scene escena = new Scene(ruta);

        //VBox contenedorVertical = new VBox(botonAgregar);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        this.setRight(contenedor);
        this.setStyle("-fx-background-color: rgba(243,177,64,0.51);");
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Juego juego) {
       /* vistaJuego = new VistaJuego(juego, canvasCentral);
        vistaJuego.dibujar();

        canvasCentral = new Canvas(460,220);

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));*/
        Image imagen = new Image("file:src/main/resources/vintageopciontres.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        //contenedorCentral.setBackground(new Background(imagenDeFondo));

        //this.setCenter(contenedorCentral);

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

    private void setTablero(Stage stage) {
        /*Label etiqueta = new Label();
        Image image = new Image("file:src/main/resources/tableroTEG.png");
        BackgroundImage imagen = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background imagenDeFondo = new Background(imagen);
        etiqueta.setBackground(imagenDeFondo);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        this.setCenter(contenedorConsola);*/
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
