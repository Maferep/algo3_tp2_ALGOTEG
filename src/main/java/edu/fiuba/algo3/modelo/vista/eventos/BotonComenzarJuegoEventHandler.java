package edu.fiuba.algo3.modelo.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {
    private TextField campo;
    private Label texto;

    public BotonComenzarJuegoEventHandler(TextField textField, Label label) {
        campo = textField;
        texto = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.campo.getText().trim().equals("")) {
            this.texto.setText("Debe ingresar jugadores");
            this.campo.requestFocus();
        } else {
            this.texto.setText("¡Que comience el juego!");
        }
    }
}
