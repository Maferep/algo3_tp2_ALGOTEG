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

    public VistaMoverEjercitos(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void visualizar() {
        IJugador jugadorActual = juego.jugadorActual();
        HBox contenedorAdyacentes = new HBox();
        List<IPais> paises = jugadorActual.obtenerPaises();
		for(IPais unPais : paises){
            Button paisJugador = new Button(unPais.obtenerNombre());
            //TODO
            Button botonVolverAColocar = new Button("Volver");
            EventoVista adyacentes = new EventoVista(
                new VistaPaisesDestinoEjercitos(juego, contenedorJuego, unPais, botonVolverAColocar)
            );

            paisJugador.setOnAction(adyacentes);
            contenedorAdyacentes.getChildren().add(paisJugador);
        }
        contenedorJuego.definirSobreMapa(contenedorAdyacentes);

    }
    
}
