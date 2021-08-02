package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private Label texto;
    private TextField campoParaTexto;
    private ContenedorJuego contenedorJuego;
    private VBox contenedor;
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;

    public BotonComenzarJuegoEventHandler(TextField campo, Label label,VBox contenedor, ContenedorJuego contenedorJuego) {
        this.campoParaTexto = campo;
        this.texto = label;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.campoParaTexto.getText().trim().equals("")) {
            this.texto.setText("Debe ingresar jugadores");
            this.campoParaTexto.requestFocus();
        }
        else if (((Integer.parseInt(this.campoParaTexto.getText())) < minimoJugadores) || ((Integer.parseInt(this.campoParaTexto.getText())) > maximoJugadores)) {
            this.texto.setText("Ingresar mas de dos y menos de seis jugadores");
            this.campoParaTexto.requestFocus();
        }
        else {
            int cantidadDeJugadores = (Integer.parseInt(this.campoParaTexto.getText()));
            VBox contenedorBotones = new VBox();
            VisualizadorFaseInicio faseInicio = null;
            try {
                faseInicio = new VisualizadorFaseInicio(cantidadDeJugadores, contenedorBotones, this.contenedorJuego);
            } catch (Exception e) {
                //TODO pedir cantidad de jugadores de nuevo / reportar error fatal
            }
            faseInicio.visualizar(contenedorBotones);
            this.contenedorJuego.setRight(contenedorBotones);
        }
    }
}