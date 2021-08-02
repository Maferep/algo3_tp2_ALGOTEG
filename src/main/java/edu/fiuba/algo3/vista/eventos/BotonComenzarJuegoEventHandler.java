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
    private ContenedorJuego contenedor;
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;

    public BotonComenzarJuegoEventHandler(TextField campo, Label label, ContenedorJuego contenedorJuego) {
        this.campoParaTexto = campo;
        this.texto = label;
        this.contenedor = contenedorJuego;
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
            VBox contenedor = new VBox();
            VisualizadorFaseInicio faseInicio = null;
            while(faseInicio == null) {
                try {
                    faseInicio = new VisualizadorFaseInicio(cantidadDeJugadores, contenedor, this.contenedor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            faseInicio.visualizar();
            this.contenedor.setRight(contenedor);
        }
    }
}