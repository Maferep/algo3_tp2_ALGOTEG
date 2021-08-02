package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonMostrarJugadorActual;
import edu.fiuba.algo3.vista.eventos.BotonPaisColocarParaFaseInicioEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.eventos.PasajeDeFases;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class VisualizadorFaseColocar implements IVista, IVistaFases {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;

    public VisualizadorFaseColocar(Juego juego, ContenedorJuego contenedorJuego) {
        this.contenedor = new VBox();
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void visualizar() {
        Label titulo = new Label();
        titulo.setText("Tenes " + juego.jugadorActual().cantidadEjercitosPorColocar() + " ejércitos por colocar.");
        contenedor.getChildren().add(titulo);

        mostrarPaises();
        this.mostrarSiguienteJugador(contenedor);
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarPaises() {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button(pais.obtenerNombre());
            contenedor.getChildren().add(botonPais);
            //BotonPaisColocarParaFaseInicioEventHandler botonColocar = new BotonPaisColocarParaFaseInicioEventHandler(pais, this.juego, this.contenedorJuego, this.visualizadorFaseInicio);
            //botonPais.setOnAction(botonColocar);
        }

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
        //mostrarBotonVolver(contenedor);

    }

    /*private void mostrarBotonVolver(VBox contenedor) {
        Button botonDos = new Button();
        botonDos.setText("Volver");

        contenedor.getChildren().add(botonDos);
        BotonVolver botonVolver = new BotonVolver(this.contenedorJuego, this.visualizadorFaseInicio);
        botonDos.setOnAction(botonVolver);

        this.contenedorJuego.setRight(contenedor);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }*/

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
        PasajeDeFases haciaFaseAtacar = new PasajeDeFases(new VisualizadorFaseAtacar(juego, contenedorJuego));
        haciaFaseAtacar.visualizar();
    }
}