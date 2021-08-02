package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTarjetas implements IVista{

	private Juego juego;
    private ContenedorJuego contenedorJuego;

    public VistaTarjetas(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }
    
    public void visualizar() {
        HBox tarjetasJugador = new HBox(5);
        List<Tarjeta> tarjetas = juego.jugadorActual().obtenerTarjetas();
        for(Tarjeta tarjeta : tarjetas){
            Label nombreTarjeta = new NombreJugador(tarjeta.obtenerPais().obtenerNombre());
            Label simboloTarjeta = new NombreJugador(tarjeta.obtenerSimbolo().simbolo);
            VBox contenedorTarjeta = new VBox(nombreTarjeta, simboloTarjeta);
            tarjetasJugador.getChildren().add(contenedorTarjeta);
        }
        if(tarjetas.isEmpty()){

            Label sinCartas = new Label("No tienes ninguna tarjeta de pais :(");
            tarjetasJugador.getChildren().add(sinCartas);
        }
        contenedorJuego.definirSobreMapa(tarjetasJugador);
    }

}
