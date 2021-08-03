package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.fases.FaseInicio;
import edu.fiuba.algo3.vista.eventos.BotonPaisAtacarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonPaisColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.eventos.PasajeDeFases;
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
        escribirTitulo();
        mostrarPaises();
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
}
