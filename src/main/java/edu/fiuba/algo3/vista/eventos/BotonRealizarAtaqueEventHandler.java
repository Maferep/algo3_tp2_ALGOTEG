package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VisualizadorAtaque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class BotonRealizarAtaqueEventHandler implements EventHandler<ActionEvent> {
    Juego juego;
    IPais atacante;
    IPais defensor;
    TextField atacanteCampo;
    VisualizadorAtaque visualizador;

    public BotonRealizarAtaqueEventHandler(Juego juego, IPais atacante, IPais defensor, TextField atacanteCampo, VisualizadorAtaque visualizador) {
        this.juego = juego;
        this.atacante = atacante;
        this.defensor = defensor;
        this.atacanteCampo = atacanteCampo;
        this.visualizador = visualizador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int ejercitos = 0;
        if (atacanteCampo.getText().matches("\\d+")) {
            ejercitos = Integer.parseInt(atacanteCampo.getText());

            try {
                juego.atacar(atacante, ejercitos, defensor);
                visualizador.mostrarResultado();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
