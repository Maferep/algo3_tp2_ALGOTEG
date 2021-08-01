package edu.fiuba.algo3.modelo.vista;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class VisualizadorFaseInicio {
    VBox contenedor;
    Juego juego;
    //TODO diccionario de colores a colores de javafx
    public VisualizadorFaseInicio(int cantidadJugadores, VBox contenedor) throws Exception {
        this.contenedor = contenedor;
        juego = new Juego(cantidadJugadores);
    }

    /*
        Muetra los colores de los jugadores en orden.
        No sé cómo mostrar cada rectángulo separado por un espacio.
    */
    public void visualizar() {
        List<String> colores = juego.obtenerNombresDeColores();
        Rectangle rectangulo;
        HBox cajaDeColores = new HBox();
        cajaDeColores.setSpacing(10);
        Color color;
        for(String nombreColor : colores){
            rectangulo = new Rectangle(30,30);
            //TODO imprimir cada color mediante un diccionario
            rectangulo.setFill(new Color(0.420,0.69,0.1313, 1));
            cajaDeColores.getChildren().add(rectangulo);
        }
        contenedor.getChildren().add(cajaDeColores);    
        
        //imprimir: "de izquierda a derecha, sus colores son... tal, tal, tal"
    }
}