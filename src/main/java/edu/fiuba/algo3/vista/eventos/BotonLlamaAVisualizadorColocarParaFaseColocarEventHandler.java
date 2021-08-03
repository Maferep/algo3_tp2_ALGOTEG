package edu.fiuba.algo3.vista.eventos;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorColocar;
import edu.fiuba.algo3.vista.VisualizadorColocarParaFaseInicio;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonLlamaAVisualizadorColocarParaFaseColocarEventHandler implements EventHandler<ActionEvent> {
    VisualizadorColocar faseColocar;

    public BotonLlamaAVisualizadorColocarParaFaseColocarEventHandler(Juego juego, ContenedorJuego contenedorJuego, IVista visualizadorFaseColocar) {
        try {
            faseColocar = new VisualizadorColocar(juego, contenedorJuego, visualizadorFaseColocar);
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        faseColocar.visualizar();
    }
}