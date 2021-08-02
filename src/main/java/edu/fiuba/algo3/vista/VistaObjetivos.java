package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonMostrarPaisesConquistados;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaObjetivos implements IVista{

    VBox contenedorObjetivos;
    private VBox contenedor;
    private int indiceObjetivo;
    List<String> objetivos;
    Button botonSiguiente;
    MostrarObjetivoHandler objetivoHandler;
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;
    

	public VistaObjetivos(Juego juego, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juego = juego;
        this.contenedor = new VBox();
        this.contenedorJuego = contenedorJuego;
        botonSiguiente = new Button("Siguiente objetivo");
        objetivos = juego.obtenerObjetivos();
        contenedorObjetivos = new VBox();
        objetivoHandler = new MostrarObjetivoHandler(this);
        botonSiguiente.setOnAction(objetivoHandler);
        this.visualizadorFaseInicio = visualizadorFaseInicio;
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
        contenedorJuego.definirBotonera(contenedor);
    }

    /*
        El evento mostrarObjetivoHandler causa que se llame a este método
    */
    public void mostrarObjetivo() {
        VBox contenedor = new VBox();
        Label label = new Label();
        label.setText(objetivos.get(indiceObjetivo));
        contenedor.getChildren().clear();
        contenedor.getChildren().add(label);
        contenedor.getChildren().add(botonSiguiente);
        indiceObjetivo++;

        if(indiceObjetivo >= objetivos.size()){
            contenedor.getChildren().clear();
            botonSiguiente.setOnAction( new BotonMostrarPaisesConquistados(
                juego,
                    this.contenedorJuego, this.visualizadorFaseInicio));
        }
        mostrarBotonVolver(contenedor);
    }

    private void mostrarBotonVolver(VBox contenedor) {
        Button botonDos = new Button();
        botonDos.setText("Volver");

        contenedor.getChildren().add(botonDos);
        BotonVolver botonVolver = new BotonVolver(this.contenedorJuego, this.visualizadorFaseInicio);
        botonDos.setOnAction(botonVolver);

        this.contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
