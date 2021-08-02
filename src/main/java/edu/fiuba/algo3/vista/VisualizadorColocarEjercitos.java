package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
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

        titulo.setText("Tenes" + juego.jugadorActual().cantidadEjercitosPorColocar() + "ejércitos por colocar");
        TextField campoCantidadEjercitos = new TextField("Ingrese  la cantidad de ejércitos a colocar en" + pais.obtenerNombre());

        contenedor.getChildren().add(titulo);
        contenedor.getChildren().add(campoCantidadEjercitos);
        contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
