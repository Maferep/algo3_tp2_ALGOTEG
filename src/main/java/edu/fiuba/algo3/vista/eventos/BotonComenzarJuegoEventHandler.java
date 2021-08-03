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

    public BotonComenzarJuegoEventHandler(TextField campo, Label label, ContenedorJuego contenedorJuego) {
        this.campoParaTexto = campo;
        this.texto = label;
        this.contenedor = contenedorJuego.obtenerBotonera();
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.verificarEntradaDeTexto(this.campoParaTexto);
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
            VisualizadorFaseInicio faseInicio = null;
            try {
                faseInicio = new VisualizadorFaseInicio(cantidadDeJugadores, this.contenedorJuego);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
            faseInicio.visualizar();
        }
    }

    private void verificarEntradaDeTexto(TextField texto) {
        if(!texto.getText().matches("\\d+")) {
            texto.setText("");
        }
    }
}