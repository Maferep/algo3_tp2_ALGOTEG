package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonColocarEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class VisualizadorColocarEjercitos {
    IPais pais;
    Juego juego;
    ContenedorJuego contenedorJuego;

    public VisualizadorColocarEjercitos(IPais pais, Juego juego, ContenedorJuego contenedorJuego) {
        this.pais = pais;
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    public void visualizar() {
        Label titulo = new Label();
        VBox contenedor = new VBox();

        int cantidadEjercitosDisponibles = juego.jugadorActual().cantidadEjercitosPorColocar();

        titulo.setText("Tenes " + cantidadEjercitosDisponibles + " ejércitos por colocar.");
        TextField campoCantidadEjercitos = new TextField();
        Button botonColocar = new Button("Colocar");

        BotonColocarEventHandler colocarEvento = new BotonColocarEventHandler(pais, juego, campoCantidadEjercitos, contenedorJuego);
        botonColocar.setOnAction(colocarEvento);

        contenedor.getChildren().addAll(titulo, campoCantidadEjercitos, botonColocar);
        contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
