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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class BotonColocarEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    Juego juego;
    TextField campoEjercitos;
    ContenedorJuego contenedorJuego;

    public BotonColocarEventHandler(IPais pais, Juego juego, TextField campo, ContenedorJuego contenedorJuego) {
        this.pais = pais;
        this.juego = juego;
        this.campoEjercitos = campo;
        this.contenedorJuego = contenedorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int ingresoUsuario = 0;
        if (campoEjercitos.getText().isEmpty()) {
            //TODO
            //agregar mensaje
        }
        ingresoUsuario = Integer.parseInt(campoEjercitos.getText());
        try {
            juego.ubicarEjercitosEnPais(ingresoUsuario, pais);
        } catch (FichasInsuficientesException e) {
            //TODO
            //agregar mensaje
        } catch (PaisNoExistenteException e) {
            e.printStackTrace();
        } catch (EjercitosException e) {
            e.printStackTrace();
        } catch (FaseErroneaException e) {
            e.printStackTrace();
        }

        VisualizadorFaseColocar visualizadorFaseColocar = new VisualizadorFaseColocar(juego, contenedorJuego);
        visualizadorFaseColocar.visualizar();

    }

    /*private void mostrarBotonVolver(VBox contenedor) {
        VBox contenedor = new VBox();
        this.visualizadorFaseInicio.visualizar(contenedor);
    }*/
}
