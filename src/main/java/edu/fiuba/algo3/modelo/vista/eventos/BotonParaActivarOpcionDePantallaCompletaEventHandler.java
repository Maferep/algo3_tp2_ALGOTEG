package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.vista.BarraDeMenu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BotonParaActivarOpcionDePantallaCompletaEventHandler implements EventHandler<KeyEvent> {

    private Stage stage;
    private BarraDeMenu menuBar;

    public BotonParaActivarOpcionDePantallaCompletaEventHandler(Stage stage, BarraDeMenu menuBar) {
        this.stage = stage;
        this.menuBar = menuBar;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
            menuBar.aplicacionMaximizada();
        }
    }
}