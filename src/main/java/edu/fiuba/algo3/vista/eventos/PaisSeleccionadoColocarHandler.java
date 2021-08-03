package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VistaCantidadEjercitosAColocarFaseInicio;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class PaisSeleccionadoColocarHandler implements EventHandler<ActionEvent> {
    IPais pais;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    Juego juego;
    IVista visualizadorFaseInicio;

    public PaisSeleccionadoColocarHandler(IPais pais, Juego juego, ContenedorJuego contenedorJuego, IVista visualizadorFaseInicio) {
        this.pais = pais;
        this.contenedor = new VBox();
        this.contenedorJuego = contenedorJuego;
        this.juego = juego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        VistaCantidadEjercitosAColocarFaseInicio vistaColocarEjercitosEnPais 
            = new VistaCantidadEjercitosAColocarFaseInicio(pais, juego, contenedorJuego, visualizadorFaseInicio);
        vistaColocarEjercitosEnPais.visualizar();
    }
}
