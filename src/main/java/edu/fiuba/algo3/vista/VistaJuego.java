package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;

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
