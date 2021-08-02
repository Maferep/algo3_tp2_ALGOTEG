package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NombreJugador extends Label {
    public NombreJugador(Color color, Background fondo, String texto) {
        super();
        this.setTextFill(color);
        this.setText(texto);
        this.setMinWidth(10);
        this.setMinSize(10,10);
        this.setBackground(fondo);
        this.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));
    }

    public NombreJugador(String texto) {
        super();
        this.setTextFill(Color.BLACK);
        this.setText(texto);
        this.setMinWidth(10);
        this.setMinSize(10,10);
        this.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));
    }
    
}