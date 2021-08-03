package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.*;
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

public class VistaPaisesColocarEjercitos implements IVista, IVistaFases {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;


    @Override
    public void visualizar() {
        agregarTitulo();
        mostrarPaises();
        mostrarSiguienteJugador();
        contenedorJuego.definirBotonera(contenedor);
    }

    private void agregarTitulo() {
        Label titulo = new Label();
        titulo.setText("Tenes " + juego.jugadorActual().cantidadEjercitosPorColocar() + " ejércitos por colocar.");
        contenedor.getChildren().add(titulo);
    }

    private void mostrarPaises() {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button(pais.obtenerNombre());
            contenedor.getChildren().add(botonPais);
            BotonPaisColocarEventHandler botonColocar = new BotonPaisColocarEventHandler(pais, this.juego, this.contenedorJuego, this);
            botonPais.setOnAction(botonColocar);
        }
    }

    private void mostrarSiguienteJugador() {
        BotonSiguienteJugador siguienteJugadorBtn = new BotonSiguienteJugador(juego, contenedorJuego, this);
        contenedor.getChildren().add(siguienteJugadorBtn);
    }

    public void visualizarNuevaFase() {
        new VisualizadorFaseAtacar(juego, contenedorJuego).visualizar();
    }

    public boolean esFaseInicioOColocar() {
        return true;
    }
}