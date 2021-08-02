package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonFaseColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonMostrarJugadorActual;
import edu.fiuba.algo3.vista.eventos.BotonMostrarPaisesConquistados;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.*;

public class VisualizadorFaseInicio implements IVista{
    Juego juego;
    int cantidadDeJugadores;
    ContenedorJuego contenedorJuego;

    static String ARCHIVO_FONDO = "file:src/main/resources/fondoBlanco.jpeg";

    Map <String,Color> coloresParaJugadores = new HashMap <String,Color>();

    public VisualizadorFaseInicio(int cantidadJugadores, ContenedorJuego contenedorJuego) throws Exception {
        this.cantidadDeJugadores = cantidadJugadores;
        this.contenedorJuego = contenedorJuego;
        this.cargarColores(this.coloresParaJugadores);
        juego = crearJuego(this.cantidadDeJugadores);
    }

    private void cargarColores(Map <String,Color> coloresParaJugadores) {
        coloresParaJugadores.put("Azul",Color.web("#0000FF", 1.0));
        coloresParaJugadores.put("Rojo",Color.web("#DC143C", 1.0));
        coloresParaJugadores.put("Amarillo",Color.web("#FFD700", 1.0));
        coloresParaJugadores.put("Verde",Color.web("#008000", 1.0));
        coloresParaJugadores.put("Rosa",Color.web("#FF69B4", 1.0));
        coloresParaJugadores.put("Negro",Color.web("#000000", 1.0));
    }

    public void visualizar(ContenedorJuego contenedorJuego) {
        VBox contenedor = new VBox();

        //comentar para probar
        /* this.imprimirJugador(juego.jugadorActual(), contenedor);
        this.mostrarCantidadDeEjercitos(contenedor);
        this.mostrarPaisesConquistados(contenedor);
        this.colocarEjercitos(contenedor);
        this.mostrarObjetivos(contenedor);
        this.mostrarSiguienteJugador(contenedor); */

        this.mostrarBotonRegrupar(contenedor);



        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
        contenedorJuego.definirBotonera(contenedor);
        //this.contenedorJuego.setRight(contenedor);
    }

    private void mostrarBotonRegrupar(VBox contenedor) {
        EventoMostrarReagrupar eventoReagrupar 
            = new EventoMostrarReagrupar(juego, contenedorJuego);
    }

    private Color obtenerColorDelJugadorActual(IJugador jugador) {
        return (this.coloresParaJugadores.get(jugador.obtenerColor()));
    }

    private void imprimirJugador(IJugador jugador, VBox contenedor) {
        javafx.scene.image.Image imagen = new Image(ARCHIVO_FONDO);
        BackgroundImage imagenDeFondo= new BackgroundImage(
            imagen, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            BackgroundSize.DEFAULT);
        Color color = this.obtenerColorDelJugadorActual(jugador);
        Label nombreJugador = new NombreJugador(
            color, 
            new Background(imagenDeFondo), 
            "Jugador " + jugador.obtenerColor());
        
        contenedor.getChildren().add(nombreJugador);
    }

    private Juego crearJuego(int cantidadJugadores) throws Exception {
        Juego juego = new Juego(cantidadJugadores);
        return juego;
    }

    private void mostrarObjetivos(VBox contenedor) {
            Button boton = new Button();
            boton.setText("Mostrar Objetivos");
            contenedor.getChildren().add(boton);
            EventoMostrarObjetivos objetivos = new EventoMostrarObjetivos(
                    juego, this.contenedorJuego, this
            );
            boton.setOnAction(objetivos);
    }

    private void mostrarPaisesConquistados(VBox contenedor) {
        Button boton = new Button();
        boton.setText("Mostrar paises conquistados");

        contenedor.getChildren().add(boton);

        BotonMostrarPaisesConquistados botonMostrarPaisesConquistados = new BotonMostrarPaisesConquistados(juego, this.contenedorJuego, this);
        boton.setOnAction(botonMostrarPaisesConquistados);
    }

    private void mostrarCantidadDeEjercitos(VBox contenedor) {
        Label texto = new Label();
        texto.setText("Cantidad fichas para colocar: " + juego.jugadorActual().cantidadEjercitosPorColocar());
        contenedor.getChildren().add(texto);
    }

    private void colocarEjercitos(VBox contenedor) {
        Button colocarEjercitos = new Button("Colocar ejércitos");
        BotonFaseColocarEventHandler eventoColocar = new BotonFaseColocarEventHandler(juego, contenedorJuego, this);
        colocarEjercitos.setOnAction(eventoColocar);
        contenedor.getChildren().add(colocarEjercitos);
    }

    private void mostrarSiguienteJugador(VBox contenedor) {
        Button boton = new Button();
        boton.setText("Siguiente Jugador");
        contenedor.getChildren().add(boton);
        BotonMostrarJugadorActual botonJugadorActual = new BotonMostrarJugadorActual(
                juego, this.contenedorJuego, this
        );
        boton.setOnAction(botonJugadorActual);
    }

}