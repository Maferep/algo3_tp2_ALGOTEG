package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.vista.eventos.EventoVista;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class VistaMoverEjercitos implements IVista {
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    private Button botonVolver;

    public VistaMoverEjercitos(Juego juego, ContenedorJuego contenedorJuego, Button botonVolver) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.botonVolver = botonVolver;
    }

    @Override
    public void visualizar() {
        contenedorJuego.limpiarAreaMapa();
        //TODO limpiar botonera
        contenedorJuego.obtenerBotonera().getChildren().clear();
        IJugador jugadorActual = juego.jugadorActual();
        HBox contenedorAdyacentes = new HBox();
        List<IPais> paises = jugadorActual.obtenerPaises();
		for(IPais unPais : paises){
            Button paisJugador = new Button(unPais.obtenerNombre());
            //TODO
            Button botonVolverAColocar = new Button("Volver");
            botonVolverAColocar.setOnAction(new EventoVista(this));
            EventoVista adyacentes = new EventoVista(
                new VistaPaisesDestinoEjercitos(
                    juego, contenedorJuego, unPais, botonVolverAColocar)
            );

            paisJugador.setOnAction(adyacentes);
            contenedorAdyacentes.getChildren().add(paisJugador);
        }
        contenedorAdyacentes.getChildren().add(botonVolver);
        contenedorJuego.definirSobreMapa(contenedorAdyacentes);

    }
    
}
