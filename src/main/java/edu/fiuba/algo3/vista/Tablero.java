package edu.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Tablero extends VBox {

    public Tablero(Stage stage) {
        /*this.stage = stage;
        Label etiqueta = new Label();
        Image imagenParaBoton = new Image("file:src/main/resources/tableroTEG.png");
        BackgroundImage imagenDeFondoParaBoton = new BackgroundImage(imagenParaBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        etiqueta.setBackground(new Background(imagenDeFondoParaBoton));
        this.getChildren().addAll(etiqueta);*/

        Button boton = new Button();
        boton.setText("COMENZ");
        boton.setMinSize(100, 100);

        boton.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 40));

        boton.setTextFill(Color.web("#66A7C5"));
        boton.setMinWidth(300);
        boton.setTextFill(Color.BLACK);

        Image imagenNueva = new Image("file:src/main/resources/fotovintajenueva.jpeg");
        BackgroundImage imagenNuevaFondo = new BackgroundImage(imagenNueva, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        boton.setBackground(new Background(imagenNuevaFondo));

        this.getChildren().addAll(boton);
    }
}
