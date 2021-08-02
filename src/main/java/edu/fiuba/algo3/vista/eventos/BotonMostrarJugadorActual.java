package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonMostrarJugadorActual implements EventHandler<ActionEvent> {

    Juego juegoActual;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;

    public BotonMostrarJugadorActual(Juego juego, ContenedorJuego contenedorJuego,
            VisualizadorFaseInicio visualizadorFaseInicio) {
        this.juegoActual = juego;
        this.contenedor = contenedorJuego.obtenerBotonera();
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Lo habilito cuando el jugador no tiene mas ejercitos para colocar.
        if (juegoActual.jugadorActualNoTieneEjercitos()) {
            try {
                this.juegoActual.siguienteTurno();
            } catch (TurnoException | FaseIncompletaException e) {
                System.exit(-1);
            }
            this.visualizadorFaseInicio.visualizar(contenedorJuego);
        }
    }
}
