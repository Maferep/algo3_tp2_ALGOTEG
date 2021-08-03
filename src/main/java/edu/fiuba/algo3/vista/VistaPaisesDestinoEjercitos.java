package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;
import edu.fiuba.algo3.vista.eventos.BotonVolver;
import edu.fiuba.algo3.vista.eventos.EventoVista;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class VistaPaisesDestinoEjercitos implements IVista {
    IPais pais;
    Button botonVolver;
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    private IVistaFases fase;

    public VistaPaisesDestinoEjercitos(
        Juego juego, ContenedorJuego contenedor, IPais pais, Button botonVolver, IVistaFases fase) {

        this.juego = juego;
        this.contenedorJuego = contenedor;
        this.pais = pais;
        this.botonVolver = botonVolver;
        this.fase = fase;
    }

    //TODO usar una sola impresora de botones de paises para todo
    @Override
    public void visualizar() {
        TilePane contenedor = new TilePane();
        for (IPais adyacente : pais.obtenerAdyacentes()) {
            Button botonAdyacente = new Button(adyacente.obtenerNombre());
            EventoVista pedirEjercitos = 
                new EventoVista(new VistaPedirEjercitos(
                    juego, contenedorJuego, pais, adyacente, botonVolver, fase));
            
            botonAdyacente.setOnAction(pedirEjercitos);
            contenedor.getChildren().add(botonAdyacente);
        }
        contenedor.getChildren().add(botonVolver);
        
        contenedorJuego.definirSobreMapa(contenedor);
    }

}
