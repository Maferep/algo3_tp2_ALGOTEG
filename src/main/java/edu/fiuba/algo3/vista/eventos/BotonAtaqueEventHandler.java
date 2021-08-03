package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorAtaque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtaqueEventHandler implements EventHandler<ActionEvent> {
    Juego juego;
    IPais atacante;
    IPais defensor;
    ContenedorJuego contenedorJuego;

    public BotonAtaqueEventHandler(Juego juego, IPais atacante, IPais defensor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.atacante = atacante;
        this.defensor = defensor;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorAtaque ataque = new VisualizadorAtaque(juego, atacante, defensor, contenedorJuego);
        ataque.visualizar();
    }
}
