package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseColocar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonFaseColocarEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private VBox contenedor;
    ContenedorJuego contenedorJuego;

    public BotonFaseColocarEventHandler(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedor = contenedor;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorFaseColocar faseColocar = null;
        while(faseColocar == null) {
            try {
                faseColocar = new VisualizadorFaseColocar(juego, contenedor, contenedorJuego);
            } catch (Exception e) {
                //TODO pedir cantidad de jugadores de nuevo / reportar error fatal
            }
        }
        faseColocar.visualizar();
    }
}
