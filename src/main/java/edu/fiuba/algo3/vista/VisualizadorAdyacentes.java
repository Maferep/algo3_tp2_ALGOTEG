package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonAtaqueEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;


public class VisualizadorAdyacentes implements IVista {
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    IPais pais;
    Juego juego;

    public VisualizadorAdyacentes(Juego juego, IPais pais, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.pais = pais;
        this.contenedorJuego = contenedorJuego;
        this.contenedor = new VBox();
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }

    @Override
    public void visualizar() {
        escribirTitulo();
        mostrarAdyacentes();
        agregarBotonVolver();

        contenedorJuego.definirBotonera(contenedor);
    }

    private void escribirTitulo() {
        Label titulo = new Label();
        titulo.setText("Podes atacar a:");

        contenedor.getChildren().add(titulo);
    }

    private void mostrarAdyacentes() {
        List<IPais> adyacentes = pais.obtenerAdyacentes();
        for (IPais adyacente : adyacentes) {
            if (!adyacente.obtenerConquistador().esIgualA(pais.obtenerConquistador())) {
                Button botonAdyacente = new Button();
                botonAdyacente.setText(adyacente.obtenerNombre() + " (" + adyacente.cantidadEjercitos() + " )");

                BotonAtaqueEventHandler ataqueEvento = new BotonAtaqueEventHandler(juego, pais, adyacente, contenedorJuego);
                botonAdyacente.setOnAction(ataqueEvento);

                contenedor.getChildren().add(botonAdyacente);
            }
        }
    }

    private void agregarBotonVolver() {
        Button volverBtn = new Button();
        volverBtn.setText("Volver");

        BotonVolver volver = new BotonVolver(contenedorJuego, new VisualizadorFaseAtacar(juego, contenedorJuego));
        volverBtn.setOnAction(volver);

        contenedor.getChildren().add(volverBtn);
    }

}
