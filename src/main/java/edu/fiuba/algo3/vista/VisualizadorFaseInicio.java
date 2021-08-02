package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonFaseColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonMostrarJugadorActual;
import edu.fiuba.algo3.vista.eventos.BotonMostrarPaisesConquistados;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.*;

public class VisualizadorFaseInicio {
    VBox contenedor;
    Juego juego;
    int cantidadDeJugadores;
    ContenedorJuego contenedorJuego;

    static String ARCHIVO_FONDO = "file:src/main/resources/fondoBlanco.jpeg";

    Map <String,Color> coloresParaJugadores = new HashMap <String,Color>();

    public VisualizadorFaseInicio(int cantidadJugadores, VBox contenedor, ContenedorJuego contenedorJuego) throws Exception {
        this.contenedor = contenedor;
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

    public void visualizar(VBox contenedor) {
        this.imprimirJugador(juego.jugadorActual(), contenedor);
        this.mostrarCantidadDeEjercitos(contenedor);
        this.mostrarPaisesConquistados(contenedor);
        this.colocarEjercitos(contenedor);
        this.mostrarObjetivos(contenedor);
        this.mostrarSiguienteJugador(contenedor);

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        this.contenedorJuego.setRight(contenedor);

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }

    private Color obtenerColorDelJugadorActual(IJugador jugador) {
        return (this.coloresParaJugadores.get(jugador.obtenerColor()));
    }

    private void imprimirJugador(IJugador jugador, VBox contenedor) {
        Label nombreJugador = new Label();
        javafx.scene.image.Image imagen = new Image(ARCHIVO_FONDO);
        BackgroundImage imagenDeFondo= new BackgroundImage(
            imagen, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            BackgroundSize.DEFAULT);
        Color color = this.obtenerColorDelJugadorActual(jugador);
        nombreJugador.setTextFill(color);
        nombreJugador.setText("Jugador " + jugador.obtenerColor());
        nombreJugador.setMinWidth(10);
        nombreJugador.setMinSize(10,10);
        nombreJugador.setBackground(new Background(imagenDeFondo));
        nombreJugador.setFont(Font.font("Morganite", FontWeight.EXTRA_LIGHT, 30));
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
                    juego, contenedor, this.contenedorJuego, this);
            boton.setOnAction(objetivos);
    }

    private void mostrarPaisesConquistados(VBox contenedor) {
        Button boton = new Button();
        boton.setText("Mostrar paises conquistados");

        contenedor.getChildren().add(boton);

        BotonMostrarPaisesConquistados botonMostrarPaisesConquistados = new BotonMostrarPaisesConquistados(juego,contenedor, this.contenedorJuego, this);
        boton.setOnAction(botonMostrarPaisesConquistados);
    }

    private void mostrarCantidadDeEjercitos(VBox contenedor) {
        Label texto = new Label();
        texto.setText("Cantidad fichas para colocar: " + juego.jugadorActual().cantidadEjercitosPorColocar());
        contenedor.getChildren().add(texto);
    }

    private void colocarEjercitos(VBox contenedor) {
        Button colocarEjercitos = new Button("Colocar ejércitos");
        BotonFaseColocarEventHandler eventoColocar = new BotonFaseColocarEventHandler(juego, contenedor, contenedorJuego, this);
        colocarEjercitos.setOnAction(eventoColocar);
        contenedor.getChildren().add(colocarEjercitos);
    }

    private void mostrarSiguienteJugador(VBox contenedor) {
        Button boton = new Button();
        boton.setText("Siguiente Jugador");
        contenedor.getChildren().add(boton);
        BotonMostrarJugadorActual botonJugadorActual = new BotonMostrarJugadorActual(
                juego, contenedor, this.contenedorJuego, this
        );
        boton.setOnAction(botonJugadorActual);
    }

}