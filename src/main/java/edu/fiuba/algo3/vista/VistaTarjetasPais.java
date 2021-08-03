package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.vista.eventos.ActivarTarjetaEventHandler;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
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
        contenedorJuego.definirBotonera(contenedor);
    }

    private void mostrarTarjetas() {
        List<Tarjeta> tarjetas = juego.jugadorActual().obtenerTarjetas();
        for (Tarjeta tarjeta : tarjetas ) {
            Button tarjetaBtn = new Button();
            tarjetaBtn.setText(tarjeta.obtenerPais().obtenerNombre());

            ActivarTarjetaEventHandler activarTarjetaEventHandler = new ActivarTarjetaEventHandler(juego, tarjeta, tarjetaBtn);
            tarjetaBtn.setOnAction(activarTarjetaEventHandler);

            contenedor.getChildren().add(tarjetaBtn);
        }
    }
}
