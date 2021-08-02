package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaReagrupar {

    VBox contenedorObjetivos;
    private VBox contenedor;
    Button botonSiguiente;
    MostrarObjetivoHandler objetivoHandler;
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    

	public VistaReagrupar(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }
    
    public void visualizar(){
        Button botonMoverEjercitos = new Button("Transferir Ejercitos");
        Button botonVerTarjetas = new Button("Ver Tarjetas");

        //TODO refactor polimorfismo
        MoverEjercitosHandler moverEjercitos = new MoverEjercitosHandler(juego, contenedorJuego);
        VerTarjetasHandler verTarjetas = new VerTarjetasHandler(juego, contenedorJuego);
        
        botonMoverEjercitos.setOnAction(moverEjercitos);
        botonVerTarjetas.setOnAction(verTarjetas);
        
        contenedor.getChildren().add(botonMoverEjercitos);
        contenedor.getChildren().add(botonVerTarjetas);
    }

    /*
        El evento mostrarObjetivoHandler causa que se llame a este método
    */
    public void mostrarEjercitos () {
        
    }

    public void mostrarTarjetas () {
        
    }

}
