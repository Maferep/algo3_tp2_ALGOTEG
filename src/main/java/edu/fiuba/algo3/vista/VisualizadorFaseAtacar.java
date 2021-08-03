package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.fases.FaseInicio;
import edu.fiuba.algo3.vista.eventos.*;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class VisualizadorFaseAtacar implements IVista, IVistaFases {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;

    public VisualizadorFaseAtacar(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        contenedor = new VBox();
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }

    @Override
    public void visualizar() {
        mostrarJugador();
        escribirTitulo();
        mostrarPaises();
        pasarTurno();
        contenedorJuego.definirBotonera(contenedor);
    }

    private void escribirTitulo() {
        Label titulo = new Label();
        titulo.setText("Elegi con qué país atacar.");
        contenedor.getChildren().add(titulo);
    }

    private void mostrarPaises() {
        List<IPais> paisesJugador = juego.jugadorActual().obtenerPaises();
        for (IPais pais : paisesJugador) {
            Button botonPais = new Button();
            botonPais.setText(pais.obtenerNombre() + " (" + pais.cantidadEjercitos() + ")");
            contenedor.getChildren().add(botonPais);

            BotonPaisAtacarEventHandler evento = new BotonPaisAtacarEventHandler(pais, juego, contenedorJuego);

            if (pais.cantidadEjercitos() > 1 ) { botonPais.setOnAction(evento); }
        }
    }

    public void visualizarNuevaFase() {
        PasajeDeFases haciaFaseReagrupar = new PasajeDeFases(new VisualizadorFaseReagrupar(juego, contenedorJuego));
        haciaFaseReagrupar.visualizar();
    }

    public boolean esFaseInicioOColocar() {
        return false;
    }

    private void pasarTurno() {
        Button siguienteBtn = new Button();
        siguienteBtn.setText("Siguiente Jugador");

        BotonMostrarJugadorActual siguiente = new BotonMostrarJugadorActual(juego, contenedorJuego, new VisualizadorFaseAtacar(juego, contenedorJuego));
        siguienteBtn.setOnAction(siguiente);

        contenedor.getChildren().add(siguienteBtn);
    }

    private void mostrarJugador() {
        Label jugador = new Label();
        jugador.setText(juego.jugadorActual().obtenerColor());

        contenedor.getChildren().add(jugador);
    }
}
