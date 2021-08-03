package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.vista.eventos.ActivarTarjetaEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class VistaTarjetasPais implements IVista {
    Juego juego;
    ContenedorJuego contenedorJuego;
    VBox contenedor;

    public VistaTarjetasPais(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.contenedor = new VBox();
    }

    @Override
    public void visualizar() {
        mostrarTarjetas();
        mostrarBotonVolver();
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarTarjetas() {
        List<Tarjeta> tarjetas = juego.jugadorActual().obtenerTarjetas();
        for (Tarjeta tarjeta : tarjetas ) {
            Button tarjetaBtn = new Button();
            tarjetaBtn.setText(tarjeta.obtenerPais().obtenerNombre());
            ActivarTarjetaEventHandler activarTarjetaEventHandler = new ActivarTarjetaEventHandler(juego, tarjeta, tarjetaBtn, this);
            tarjetaBtn.setOnAction(activarTarjetaEventHandler);

            contenedor.getChildren().add(tarjetaBtn);
        }
    }

    private void mostrarBotonVolver() {
        Button volverBtn = new Button();
        volverBtn.setText("Volver");

        BotonVolver volver = new BotonVolver(contenedorJuego, new VisualizadorFaseColocar(juego, contenedorJuego));
        volverBtn.setOnAction(volver);

        contenedor.getChildren().add(volverBtn);
    }

    public void mostrarAlerta() {
        Label mensaje = new Label("No sos conquistador de ese país.");
        contenedor.getChildren().add(mensaje);
        contenedorJuego.definirBotonera(contenedor);
    }
}
