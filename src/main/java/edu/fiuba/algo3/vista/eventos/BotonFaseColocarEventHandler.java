package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseColocar;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonFaseColocarEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;

    public BotonFaseColocarEventHandler(Juego juego, ContenedorJuego contenedorJuego, VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorFaseColocar faseColocar = null;
        while(faseColocar == null) {
            try {
                faseColocar = new VisualizadorFaseColocar(juego, contenedorJuego, this.visualizadorFaseInicio);
            } catch (Exception e) {
                //TODO pedir cantidad de jugadores de nuevo / reportar error fatal
            }
        }
        faseColocar.visualizar(contenedorJuego);
    }
}
