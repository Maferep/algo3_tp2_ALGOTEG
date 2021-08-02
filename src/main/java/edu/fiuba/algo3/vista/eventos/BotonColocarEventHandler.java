package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteException;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorFaseColocar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonColocarEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    Juego juego;
    int cantidadEjercitos;

    public BotonColocarEventHandler(IPais pais, Juego juego, int cantidadEjercitos) {
        this.pais = pais;
        this.juego = juego;
        this.cantidadEjercitos = cantidadEjercitos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.ubicarEjercitosEnPais(cantidadEjercitos, pais);
        } catch (FichasInsuficientesException e) {
            e.printStackTrace();
        } catch (PaisNoExistenteException e) {
            e.printStackTrace();
        } catch (EjercitosException e) {
            e.printStackTrace();
        } catch (FaseErroneaException e) {
            e.printStackTrace();
        }

    }
}
