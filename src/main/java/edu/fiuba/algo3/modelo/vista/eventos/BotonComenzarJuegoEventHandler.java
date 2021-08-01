package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private Label texto;
    private TextField campoParaTexto;
    private ContenedorJuego contenedorJuego;
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;

    public BotonComenzarJuegoEventHandler(TextField campo, Label label, ContenedorJuego contenedorJuego) {
        this.campoParaTexto = campo;
        this.texto = label;
        // TODO para que se usa el contenedorJuego?
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
            VBox contenedor = new VBox();
            VisualizadorFaseInicio faseInicio = null;
            
            try {
                faseInicio = new VisualizadorFaseInicio(cantidadDeJugadores, contenedorJuego);
            } catch (Exception e) {
                System.exit(-1);
            }
            
            faseInicio.visualizar();
            this.contenedorJuego.setRight(contenedor);
        }
    }
}