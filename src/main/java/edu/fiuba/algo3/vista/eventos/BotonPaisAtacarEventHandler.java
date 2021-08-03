package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorAdyacentesEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPaisAtacarEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    Juego juego;
    ContenedorJuego contenedorJuego;

    public BotonPaisAtacarEventHandler(IPais pais, Juego juego, ContenedorJuego contenedorJuego) {
        this.pais = pais;
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorAdyacentesEventHandler visualizadorAdyacentesEventHandler 
            = new VisualizadorAdyacentesEventHandler(juego, pais, contenedorJuego);
        visualizadorAdyacentesEventHandler.visualizar();
    }
}
