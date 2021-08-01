package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.vista.eventos.VisualizarFaseHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonSiguiente extends Button {
    public BotonSiguiente(VisualizadorFase fase) {
        setText("Siguiente");
        setMinSize(800, 100);
        setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 40));
        setMinWidth(300);
        setTextFill(Color.BLACK);
        //setBackground(new Background(imagenDeFondoParaBoton));
        VisualizarFaseHandler handler = new VisualizarFaseHandler(fase);
        this.setOnAction(handler);
    }

    
    
}
