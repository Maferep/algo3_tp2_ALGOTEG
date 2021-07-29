package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaJuego {

    private Juego juego;
    Canvas canvas;

    public VistaJuego(Juego juego, Canvas canvasCentral) {
        this.juego = juego;
        this.canvas = canvasCentral;
    }

    public void dibujar() {
        this.dibujarMapa();
    }

    private void dibujarMapa() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        //canvas.getGraphicsContext2D().fillOval(juego.); //le pido info a juego
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0,0,460,220);
    }

    public void update() {
        this.dibujarMapa();
    }
}
