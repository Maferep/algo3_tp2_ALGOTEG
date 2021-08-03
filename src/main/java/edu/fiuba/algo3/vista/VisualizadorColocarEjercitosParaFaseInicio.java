package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.AlgoTegException;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonColocarParaFaseInicioEventHandler;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class VisualizadorColocarEjercitosParaFaseInicio {
    IPais pais;
    Juego juego;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseInicio;

    public VisualizadorColocarEjercitosParaFaseInicio(
                IPais pais, Juego juego, 
                ContenedorJuego contenedorJuego, IVista visualizadorFaseInicio){
        this.pais = pais;
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }

    public void visualizar() {
        contenedorJuego.limpiarAreaMapa();
        contenedorJuego.limpiarBotonera();
        Label titulo = new Label();
        VBox contenedor = new VBox();

        int cantidadEjercitosDisponibles = juego.jugadorActual().cantidadEjercitosPorColocar();

        titulo.setText("Tenes " + cantidadEjercitosDisponibles + " ejércitos por colocar.");
        TextField campoCantidadEjercitos = new TextField();
        Button botonColocar = new Button("Colocar");

        BotonColocarParaFaseInicioEventHandler colocarEvento = new BotonColocarParaFaseInicioEventHandler(pais, juego, campoCantidadEjercitos,titulo, contenedorJuego, this.visualizadorFaseInicio);
        botonColocar.setOnAction(colocarEvento);

        contenedor.getChildren().addAll(titulo, campoCantidadEjercitos, botonColocar);
        contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
