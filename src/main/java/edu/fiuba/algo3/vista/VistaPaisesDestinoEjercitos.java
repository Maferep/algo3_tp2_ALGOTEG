package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.vista.eventos.EventoVista;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaPaisesDestinoEjercitos implements IVista {
    IPais pais;
    Button botonVolver;
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    public VistaPaisesDestinoEjercitos(Juego juego,
        ContenedorJuego contenedor, IPais pais, Button botonVolver) {

        this.juego = juego;
        this.contenedorJuego = contenedor;
        this.pais = pais;
        this.botonVolver = botonVolver;
	}

	@Override
    public void visualizar() {
        HBox contenedor = new HBox();
        for(IPais adyacente : pais.obtenerAdyacentes()){
            Button botonAdyacente = new Button(adyacente.obtenerNombre());
            EventoVista moverEjercitos 
                = new EventoVista(
                        new MoverEjercitos(
                            juego, contenedorJuego, pais, adyacente, botonVolver));
            botonAdyacente.setOnAction(moverEjercitos);
            contenedor.getChildren().add(botonAdyacente);
        }
        contenedor.getChildren().add(botonVolver);
        contenedorJuego.definirSobreMapa(contenedor);
    }

}
