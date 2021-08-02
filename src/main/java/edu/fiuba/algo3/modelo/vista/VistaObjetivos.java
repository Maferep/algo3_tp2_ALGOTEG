package edu.fiuba.algo3.modelo.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaObjetivos {

    VBox contenedorObjetivos;
    private VBox contenedor;
    private int indiceObjetivo;
    List<String> objetivos;

	public VistaObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.contenedor = contenedor;
        
        objetivos = juego.obtenerObjetivos();
        contenedorObjetivos = new VBox();
    }
    
    public void visualizar(){
        Label label = new Label("Vamos a mostrar los objetivos.\n"+
        " Si este no es tu color, volteate");
        contenedor.getChildren().add(label);
        //TODO buscar el color
        Button botonMostrarObjetivo = new Button("Mostrar!");
        MostrarObjetivoHandler objetivoHandler = new MostrarObjetivoHandler(this);
        botonMostrarObjetivo.setOnAction(objetivoHandler);
        contenedor.getChildren().add(botonMostrarObjetivo);
    }

    /*
        El evento mostrarObjetivoHandler causa que se llame a este método
    */
    public void mostrarObjetivo() {
        Label label = new Label();
        label.setText(objetivos.get(indiceObjetivo));
        contenedor.getChildren().clear();
        contenedor.getChildren().add(label);
        indiceObjetivo++;
    }

}
