package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.manejadores.BotonComenzarJuego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
        Label texto = new Label();
        texto.setText("Ingrese cantidad de jugadores");

        TextField campo = new TextField();
        campo.setPromptText("Ingrese el cantidad de jugadores");

        Button boton = new Button();
        boton.setText("Empezar juego");

        VBox contenedor = new VBox(tablero, texto, campo, boton);

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        BotonComenzarJuego botonEnviarEventHandler = new BotonComenzarJuego(campo, texto);
        boton.setOnAction(botonEnviarEventHandler);

        Scene escena = new Scene(ruta);

        stage.setTitle("AlgoTeg");
        stage.setResizable(false);
        stage.setScene(escena);
        stage.sizeToScene();

        stage.show();
    }
}
