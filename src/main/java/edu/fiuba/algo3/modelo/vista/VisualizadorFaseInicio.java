package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.layout.VBox;

public class VisualizadorFaseInicio {
    VBox contenedor;
    Juego juego;
    public VisualizadorFaseInicio(int cantidadJugadores, VBox contenedor) throws Exception {
        this.contenedor = contenedor;
        Juego juego = new Juego(cantidadJugadores);
    }

    public void visualizar() {
        //TODO obtener lista de colores y mostrarla a los jugadores
        //imprimir: "de izquierda a derecha, sus colores son... tal, tal, tal"
    }
}