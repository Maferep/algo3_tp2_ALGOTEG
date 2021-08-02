package edu.fiuba.algo3.modelo.vista;


import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
public class VisualizadorColocarEjercitosEnFaseInicio {
    IPais pais;
    Juego juego;
    ContenedorJuego contenedorJuego;

    public VisualizadorColocarEjercitosEnFaseInicio(IPais pais, Juego juego, ContenedorJuego contenedorJuego) {
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

        contenedor.getChildren().addAll(titulo, campoCantidadEjercitos, botonColocar);
        contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
