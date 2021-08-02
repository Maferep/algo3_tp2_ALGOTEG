package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;

public class VistaJuego extends Pane {

    private Juego juego;
    Canvas canvas;
    VBox contenedorCentral;

    public VistaJuego(Juego juego, Canvas canvasCentral) {
        this.juego = juego;
        this.canvas = canvasCentral;
    }

    public void dibujar() {
        this.dibujarMapa();
    }

    private void dibujarMapa() {
    }

    public void clean() {
        //canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        //canvas.getGraphicsContext2D().fillRect(0,0,460,220);
    }

    public void update() {
        this.dibujarMapa();
    }
}
