package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonPaisColocarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class VisualizadorFaseColocar {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;

    public VisualizadorFaseColocar(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.contenedor = new VBox();
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    public void visualizar() {
        mostrarPaises();

    }

    private void mostrarPaises() {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button(pais.obtenerNombre());
            contenedor.getChildren().add(botonPais);
            BotonPaisColocarEventHandler botonColocar = new BotonPaisColocarEventHandler(pais, this.contenedor, this.contenedorJuego);
            botonPais.setOnAction(botonColocar);
        }

        contenedorJuego.setRight(contenedor);
    }
}
