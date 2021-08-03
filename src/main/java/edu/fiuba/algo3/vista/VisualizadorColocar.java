package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;
import edu.fiuba.algo3.vista.eventos.BotonMostrarJugadorActual;
import edu.fiuba.algo3.vista.eventos.BotonPaisColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.PasajeDeFases;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisualizadorColocar implements IVista, IVistaFases {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseColocar;
    static String ARCHIVO_FONDO = "file:src/main/resources/fondoBlanco.jpeg";
    Map<String,Color> coloresParaJugadores = new HashMap<String,Color>();

    public VisualizadorColocar(Juego juego, ContenedorJuego contenedorJuego, IVista visualizadorFaseColocar) {
        this.contenedor = new VBox();
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseColocar = visualizadorFaseColocar;
        this.cargarColores(this.coloresParaJugadores);
    }

    private void cargarColores(Map <String,Color> coloresParaJugadores) {
        coloresParaJugadores.put("Azul",Color.web("#0000FF", 1.0));
        coloresParaJugadores.put("Rojo",Color.web("#DC143C", 1.0));
        coloresParaJugadores.put("Amarillo",Color.web("#FFD700", 1.0));
        coloresParaJugadores.put("Verde",Color.web("#008000", 1.0));
        coloresParaJugadores.put("Rosa",Color.web("#FF69B4", 1.0));
        coloresParaJugadores.put("Negro",Color.web("#000000", 1.0));
    }

    @Override
    public void visualizar() {
        VBox contenedor = new VBox();
        this.imprimirJugador(juego.jugadorActual(), contenedor);
        Label titulo = new Label();
        titulo.setText("Tenes " + juego.jugadorActual().cantidadEjercitosPorColocar() + " ejércitos por colocar.");
        contenedor.getChildren().add(titulo);
        mostrarPaises(contenedor);
        this.mostrarSiguienteJugador(contenedor);
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarPaises(VBox contenedor) {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button(pais.obtenerNombre());
            contenedor.getChildren().add(botonPais);
            BotonPaisColocarEventHandler botonColocar = new BotonPaisColocarEventHandler(pais, this.juego, this.contenedorJuego, this.visualizadorFaseColocar);
            botonPais.setOnAction(botonColocar);
        }
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
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

    private Color obtenerColorDelJugadorActual(IJugador jugador) {
        return (this.coloresParaJugadores.get(jugador.obtenerColor()));
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

    public void visualizarNuevaFase() {
        try {
            juego.siguienteFase();
        } catch (FaseIncompletaException | EjercitosException | TurnoException e) {
            System.exit(-1);
        } //prueba
        PasajeDeFases haciaFaseAtacar = new PasajeDeFases(new VisualizadorFaseAtacar(juego, contenedorJuego));
        haciaFaseAtacar.visualizar();
    }
    public boolean esFaseInicioOColocar() {
        return true;
    }

}
