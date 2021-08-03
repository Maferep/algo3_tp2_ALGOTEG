package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.AlgoTegException;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonPaisColocarParaFaseInicioEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.List;

public class VisualizadorColocarParaFaseInicio implements IVista {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseInicio;

    public VisualizadorColocarParaFaseInicio(
            Juego juego, 
            ContenedorJuego contenedorJuego, 
            IVista visualizadorFaseInicio){
        this.contenedor = new VBox();
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
        
    }

    @Override
    public void visualizar() {
        contenedorJuego.limpiarAreaMapa();
        Label titulo = new Label();
        titulo.setText("Tenes " + juego.jugadorActual().cantidadEjercitosPorColocar() + " ejércitos por colocar.");
        contenedor.getChildren().add(titulo);

        mostrarBotonVolver(contenedor);

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(40));
        contenedorJuego.definirBotonera(contenedor);
        contenedorJuego.definirSobreMapa(mostrarPaises());
    }

    private TilePane mostrarPaises() {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        TilePane contenedorPaises = new TilePane();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button(pais.obtenerNombre());
            contenedorPaises.getChildren().add(botonPais);
            BotonPaisColocarParaFaseInicioEventHandler botonColocar 
                = new BotonPaisColocarParaFaseInicioEventHandler(
                        pais, this.juego, 
                        this.contenedorJuego, 
                        this.visualizadorFaseInicio);
            botonPais.setOnAction(botonColocar);
        }
        return contenedorPaises;
        
        
    }

    private void mostrarBotonVolver(VBox contenedor) {
        Button botonDos = new Button();
        botonDos.setText("Volver");

        contenedor.getChildren().add(botonDos);
        BotonVolver botonVolver = new BotonVolver(this.contenedorJuego, this.visualizadorFaseInicio);
        botonDos.setOnAction(botonVolver);

        this.contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }
}
