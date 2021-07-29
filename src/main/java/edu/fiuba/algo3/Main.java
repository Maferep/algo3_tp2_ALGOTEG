package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.modelo.vista.ContenedorPrincipal;
import edu.fiuba.algo3.modelo.vista.eventos.AplicacionOnKeyPressEventHandler;
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

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
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

        Scene escena = new Scene(ruta);*/

        stage.setTitle("ALGOTEG");

        Juego juego = crearJuego(); //modelo
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new  AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,640,480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }

    private Juego crearJuego() {
    return null;
    }
}