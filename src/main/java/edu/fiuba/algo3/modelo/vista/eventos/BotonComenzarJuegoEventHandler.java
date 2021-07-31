package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.*;
import java.awt.*;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private Label texto;
    private TextField campoParaTexto;
    private ContenedorJuego contenedor;

    public BotonComenzarJuegoEventHandler(TextField campo, Label label, ContenedorJuego contenedor) {
        this.campoParaTexto = campo;
        this.texto = label;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.campoParaTexto.getText().trim().equals("")) {
            this.texto.setText("Debe ingresar jugadores");
            this.campoParaTexto.requestFocus();

        } else {
            this.texto.setText("¡Que comience el juego!");
            Label texto = new Label();
            texto.setText("Jugador " + this.campoParaTexto.getText());
            javafx.scene.image.Image imagen = new Image("file:src/main/resources/fondoBlanco.jpeg");
            BackgroundImage imagenDeFondo= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
            texto.setTextFill(javafx.scene.paint.Color.BLACK);
            texto.setMinWidth(10);
            texto.setMinSize(10,10);
            texto.setBackground(new Background(imagenDeFondo));
            texto.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));


            VBox contenedor = new VBox(texto);

            contenedor.setSpacing(10);
            contenedor.setPadding(new Insets(100));

            StackPane ruta = new StackPane();

            ruta.getChildren().addAll(contenedor);

            this.contenedor.setRight(contenedor);

            //Comenzar con el juego. Inicializar jugadores segun la cantidad que me escribieron en el campo.

        }
    }
}
