package edu.fiuba.algo3.modelo.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private Label texto;
    private TextField campoParaTexto;

    public BotonComenzarJuegoEventHandler(TextField campo,Label label) {
        campoParaTexto = campo;
        texto = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.campoParaTexto.getText().trim().equals("")) {
            this.texto.setText("Debe ingresar jugadores");
            this.campoParaTexto.requestFocus();

        } else {
            this.texto.setText("¡Que comience el juego!");
            //Comenzar con el juego. Inicializar jugadores segun la cantidad que me escribieron en el campo.
        }
    }
}
