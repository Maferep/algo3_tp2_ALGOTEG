package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaTarjetas {

	private Juego juego;
    private ContenedorJuego contenedorJuego;
    private VBox contenedor;

    public VistaTarjetas(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.contenedor = contenedor;
    }
    
    public void visualizar() {
        VBox tarjetasJugador = new VBox(5);
        for(Tarjeta tarjeta : juego.jugadorActual().obtenerTarjetas()){
            Label nombreTarjeta = new Label(tarjeta.obtenerPais().obtenerNombre());
            Label simboloTarjeta = new Label(tarjeta.obtenerSimbolo().simbolo);
            VBox contenedorTarjeta = new VBox(nombreTarjeta, simboloTarjeta);
            tarjetasJugador.getChildren().add(contenedorTarjeta);
            
        }
        contenedorJuego.setLeft(tarjetasJugador);
    }

}
