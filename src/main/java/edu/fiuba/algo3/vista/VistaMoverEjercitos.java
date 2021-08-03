package edu.fiuba.algo3.vista;

import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.vista.eventos.EventoVista;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class VistaMoverEjercitos implements IVista {
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    private Button botonVolver;
    private IVistaFases fase;

    public VistaMoverEjercitos(
        Juego juego, ContenedorJuego contenedorJuego, Button botonVolver, IVistaFases fase) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.botonVolver = botonVolver;
        this.fase = fase;
    }

    @Override
    public void visualizar() {
        contenedorJuego.limpiarAreaMapa();
        //TODO limpiar botonera
        contenedorJuego.obtenerBotonera().getChildren().clear();
        IJugador jugadorActual = juego.jugadorActual();
        
        TilePane contenedorAdyacentes = new TilePane();
        //todo jugador.paisesConSoldadosMovibles
        List<IPais> paisesMovibles = jugadorActual.obtenerPaises()
            .stream()
            .filter(p -> (p.cantidadEjercitos() >= 2))
            .collect(Collectors.toList());
        
		for(IPais unPais : paisesMovibles){
            Button paisJugador = new Button(unPais.obtenerNombre());
            //TODO usar BotonVolver
            Button botonVolverAColocar = new Button("Volver");
            botonVolverAColocar.setOnAction(new EventoVista(this));
            EventoVista adyacentes = new EventoVista(
                new VistaPaisesDestinoEjercitos(
                    juego, contenedorJuego, unPais, botonVolverAColocar, fase)
            );

            paisJugador.setOnAction(adyacentes);
            contenedorAdyacentes.getChildren().add(paisJugador);
        }
        VBox contenedorBotones = new VBox(contenedorAdyacentes, botonVolver);
        contenedorJuego.definirSobreMapa(contenedorBotones);

    }
    
}
