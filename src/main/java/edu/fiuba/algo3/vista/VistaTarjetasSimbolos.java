package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.eventos.SeleccionarTarjetaEventHandler;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VistaTarjetasSimbolos implements IVista {
    Juego juego;
    ContenedorJuego contenedorJuego;
    VBox contenedor;
    List<Button> botonesTarjetas;

    public VistaTarjetasSimbolos(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        contenedor = new VBox();
        botonesTarjetas = new ArrayList<>();
    }

    @Override
    public void visualizar() {
        mostrarTarjetas();
        mostrarVolverBtn();
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarTarjetas() {
        List<Tarjeta> tarjetas = juego.jugadorActual().obtenerTarjetas();
        List<Tarjeta> elegidas = new ArrayList<Tarjeta>();
        for (Tarjeta tarjeta : tarjetas) {
            Button tarjetaBtn = new Button();
            botonesTarjetas.add(tarjetaBtn);

            tarjetaBtn.setText(tarjeta.obtenerSimbolo().simbolo.toUpperCase(Locale.ROOT));
            SeleccionarTarjetaEventHandler seleccionarTarjetaEvento = new SeleccionarTarjetaEventHandler(juego, tarjeta, elegidas, tarjetaBtn, this);
            tarjetaBtn.setOnAction(seleccionarTarjetaEvento);

            contenedor.getChildren().add(tarjetaBtn);
        }
    }

    public void desactivarBotones() {
        for (Button boton : botonesTarjetas) {
            boton.setDisable(true);
        }
    }

    public void mostrarAlerta() {
        Label mensaje = new Label();
        mensaje.setText("Las tarjetas no formaban un canje válido.");

        contenedor.getChildren().add(mensaje);
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarVolverBtn() {
        Button volverBtn = new Button();
        volverBtn.setText("Volver");

        BotonVolver volverEvento = new BotonVolver(contenedorJuego, new VisualizadorFaseColocar(juego, contenedorJuego));
        volverBtn.setOnAction(volverEvento);

        contenedor.getChildren().add(volverBtn);

    }
}
