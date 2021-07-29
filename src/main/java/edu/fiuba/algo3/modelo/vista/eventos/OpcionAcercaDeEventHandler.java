package edu.fiuba.algo3.modelo.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler <ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("mensaje de alerta");
        String mensaje = "Hola mundo";
        alert.setContentText(mensaje);
        alert.show();
    }
}
