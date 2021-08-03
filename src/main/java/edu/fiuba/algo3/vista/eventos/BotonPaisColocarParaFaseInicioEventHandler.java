package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorColocarEjercitosParaFaseInicio;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonPaisColocarParaFaseInicioEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    Juego juego;
    IVista visualizadorFaseInicio;

    public BotonPaisColocarParaFaseInicioEventHandler(IPais pais, Juego juego, ContenedorJuego contenedorJuego, IVista visualizadorFaseInicio) {
        this.pais = pais;
        this.contenedor = new VBox();
        this.contenedorJuego = contenedorJuego;
        this.juego = juego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorColocarEjercitosParaFaseInicio vistaColocarEjercitosEnPais = new VisualizadorColocarEjercitosParaFaseInicio(pais, juego, contenedorJuego, visualizadorFaseInicio);
        vistaColocarEjercitosEnPais.visualizar();
    }
}
