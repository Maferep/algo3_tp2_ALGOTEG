package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.VisualizadorFaseInicio;
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

    public BotonComenzarJuegoEventHandler(TextField campo, Label label, ContenedorJuego contenedorJuego) {
        this.campoParaTexto = campo;
        this.texto = label;

        // TODO para que se usa el contenedorJuego?
        this.contenedor = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // TODO usar string to int para obtener cantidadDeJugadores
        int cantidadDeJugadores = 3;
        if (this.campoParaTexto.getText().trim().equals("")) {
            this.texto.setText("Debe ingresar jugadores");
            this.campoParaTexto.requestFocus();
            return;
        } else {
            this.texto.setText("¡Que comience el juego!");
            Label texto = new Label();
            // texto.setText("Jugador " + this.campoParaTexto.getText());
            javafx.scene.image.Image imagen = new Image("file:src/main/resources/fondoBlanco.jpeg");
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            texto.setTextFill(javafx.scene.paint.Color.BLACK);
            texto.setMinWidth(10);
            texto.setMinSize(10, 10);
            texto.setBackground(new Background(imagenDeFondo));
            texto.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));

            VBox contenedor = new VBox(texto);

            contenedor.setSpacing(10);
            contenedor.setPadding(new Insets(100));

            StackPane ruta = new StackPane();

            ruta.getChildren().addAll(contenedor);

            this.contenedor.setRight(contenedor);
            
            VisualizadorFaseInicio faseInicio = null;
            while(faseInicio == null) {
                try {
                    faseInicio = new VisualizadorFaseInicio(cantidadDeJugadores, contenedor);
                } catch (Exception e) {
                    //TODO pedir cantidad de jugadores de nuevo / reportar error fatal
                }
            }

            faseInicio.visualizar();
        }
        
    }
}
