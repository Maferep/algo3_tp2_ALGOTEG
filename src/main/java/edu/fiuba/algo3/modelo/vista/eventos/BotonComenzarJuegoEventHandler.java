package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.ContenedorRealizaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private Label texto;
    private TextField campoParaTexto;
    private ContenedorJuego contenedor;
    private Juego juego;
    private ContenedorRealizaJuego proximoContenedor;
    Stage stage;
    Scene proximaEscena;

    static int minimoJugadores = 2;
    static int maximoJugadores = 6;

    public BotonComenzarJuegoEventHandler(Stage stage, Scene proximaEscena, TextField campo, Label label, ContenedorJuego contenedor, ContenedorRealizaJuego proximoContenedor ) {
        this.campoParaTexto = campo;
        this.texto = label;
        this.contenedor = contenedor;
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.proximoContenedor = proximoContenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int i = 1;

        if (this.campoParaTexto.getText().trim().equals("")) {
            this.texto.setText("Debe ingresar jugadores");
            this.campoParaTexto.requestFocus();
        }
        else if (((Integer.parseInt(this.campoParaTexto.getText())) < minimoJugadores) || ((Integer.parseInt(this.campoParaTexto.getText())) > maximoJugadores)) {
            this.texto.setText("Ingresar mas de dos y menos de seis jugadores");
            this.campoParaTexto.requestFocus();
        }
        else {
            //this.proximoContenedor.asignarCantidadJugadores(Integer.parseInt(this.campoParaTexto.getText()));
            this.stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);

            /*this.texto.setText("¡Que comience el juego!");

            VBox contenedor = new VBox(texto);

            try {
                juego = crearJuego(Integer.parseInt(this.campoParaTexto.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            while(i <= juego.obtenerFaseActual().turno().cantidadDeJugadores() ) {
                Label texto = new Label();
                javafx.scene.image.Image imagen = new Image("file:src/main/resources/fondoBlanco.jpeg");
                BackgroundImage imagenDeFondo= new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
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

            contenedor.setSpacing(10);
            contenedor.setPadding(new Insets(100));

            StackPane ruta = new StackPane();

            ruta.getChildren().addAll(contenedor);
            this.contenedor.setRight(contenedor);*/
        }
    }

    private Juego crearJuego(int cantidadJugadores) throws Exception {
        Juego juego = new Juego(cantidadJugadores);
        return juego;
    }
}
