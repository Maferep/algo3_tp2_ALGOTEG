package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonPaisColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class VisualizadorColocar implements IVista {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseColocar;

    public VisualizadorColocar(Juego juego, ContenedorJuego contenedorJuego, IVista visualizadorFaseColocar) {
        this.contenedor = new VBox();
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseColocar = visualizadorFaseColocar;
    }

    @Override
    public void visualizar() {
        Label titulo = new Label();
        titulo.setText("Tenes " + juego.jugadorActual().cantidadEjercitosPorColocar() + " ejércitos por colocar.");
        contenedor.getChildren().add(titulo);

        mostrarPaises();
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarPaises() {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button(pais.obtenerNombre());
            contenedor.getChildren().add(botonPais);
            BotonPaisColocarEventHandler botonColocar = new BotonPaisColocarEventHandler(pais, this.juego, this.contenedorJuego, this.visualizadorFaseColocar);
            botonPais.setOnAction(botonColocar);
        }
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
        mostrarBotonVolver(contenedor);
    }

    private void mostrarBotonVolver(VBox contenedor) {
        Button botonDos = new Button();
        botonDos.setText("Volver");

        contenedor.getChildren().add(botonDos);
        BotonVolver botonVolver = new BotonVolver(this.contenedorJuego, this.visualizadorFaseColocar);
        botonDos.setOnAction(botonVolver);

        this.contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
