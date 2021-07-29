package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.vista.eventos.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) throws IOException {
        super();
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/resources/tableroTEG.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("COMENZAR JUEGO");
        botonEntrar.setMinSize(100, 100);

        botonEntrar.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 40));

        botonEntrar.setTextFill(Color.web("#66A7C5"));
        botonEntrar.setMinWidth(300);
        botonEntrar.setTextFill(Color.BLACK);

        Image imagenParaBoton = new Image("file:src/main/resources/fotovintajenueva.jpeg");
        BackgroundImage imagenDeFondoParaBoton = new BackgroundImage(imagenParaBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        botonEntrar.setBackground(new Background(imagenDeFondoParaBoton));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 35));

        etiqueta.setText("BIENVENIDOS");
        etiqueta.setTextFill(Color.BLACK);
        etiqueta.setBackground(new Background(imagenDeFondoParaBoton));

        BotonEntrarEventHandler botonEntrarEventHandler = new BotonEntrarEventHandler(stage,proximaEscena);
        botonEntrar.setOnAction(botonEntrarEventHandler);

        this.getChildren().addAll(etiqueta,botonEntrar);
    }

}
