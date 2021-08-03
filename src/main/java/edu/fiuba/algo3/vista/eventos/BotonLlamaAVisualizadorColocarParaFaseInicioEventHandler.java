package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorColocarParaFaseInicio;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonLlamaAVisualizadorColocarParaFaseInicioEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;
    VisualizadorColocarParaFaseInicio faseColocar;

    public BotonLlamaAVisualizadorColocarParaFaseInicioEventHandler(Juego juego, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
        try {
            faseColocar = new VisualizadorColocarParaFaseInicio(juego, contenedorJuego, this.visualizadorFaseInicio);
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        faseColocar.visualizar();
    }
}
