package edu.fiuba.algo3.modelo.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.eventos.BotonMostrarPaisesConquistados;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaObjetivos {

    VBox contenedorObjetivos;
    private VBox contenedor;
    private int indiceObjetivo;
    List<String> objetivos;
    Button botonSiguiente;
    MostrarObjetivoHandler objetivoHandler;
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    

	public VistaObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
        botonSiguiente = new Button("Siguiente objetivo");
        objetivos = juego.obtenerObjetivos();
        contenedorObjetivos = new VBox();
        objetivoHandler = new MostrarObjetivoHandler(this);
        botonSiguiente.setOnAction(objetivoHandler);
    }
    
    public void visualizar(){
        Label label = new Label("Vamos a mostrar los objetivos.\n"+
        " Si este no es tu color, volteate");
        contenedor.getChildren().add(label);
        //TODO buscar el color

        //Crear boton y darle el handler
        Button botonMostrarObjetivo = new Button("Mostrar!");
        botonMostrarObjetivo.setOnAction(objetivoHandler);

        //TODO encapsular getChildren.add
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
        contenedor.getChildren().add(botonSiguiente);
        indiceObjetivo++;

        if(indiceObjetivo >= objetivos.size()){
            contenedor.getChildren().clear();
            botonSiguiente.setOnAction( new BotonMostrarPaisesConquistados(
                juego, contenedor, contenedorJuego));
        }
    }

}
