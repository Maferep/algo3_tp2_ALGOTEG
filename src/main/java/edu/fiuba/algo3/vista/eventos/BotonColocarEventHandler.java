package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteException;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorColocar;
import edu.fiuba.algo3.vista.VisualizadorFaseColocar;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonColocarEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    Juego juego;
    TextField campoEjercitos;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseColocar;
    Label texto;

    public BotonColocarEventHandler(IPais pais, Juego juego, TextField campo, Label texto, ContenedorJuego contenedorJuego, IVista visualizadorFaseColocar) {
        this.pais = pais;
        this.juego = juego;
        this.campoEjercitos = campo;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseColocar = visualizadorFaseColocar;
        this.texto = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //TODO poner toda esta verificación en el constructor de VisFaseColocar
        int ingresoUsuario = 0;
        this.verificarEntradaDeTexto(this.campoEjercitos);
        if (campoEjercitos.getText().isEmpty()) {
            this.texto.setText("Debe ingresar una cantidad de ejercitos");
            this.campoEjercitos.requestFocus();
        }
        else {
            ingresoUsuario = Integer.parseInt(campoEjercitos.getText());
            try {
                juego.colocarEjercitosEnPais(ingresoUsuario, pais);
            } catch (FichasInsuficientesException e) {
                this.texto.setText("Solo tienes " + juego.jugadorActual().cantidadEjercitosPorColocar() + " ejercitos para agregar");
                this.campoEjercitos.requestFocus();
            } catch (PaisNoExistenteException e) {
                e.printStackTrace();
            } catch (EjercitosException e) {
                e.printStackTrace();
            } catch (FaseErroneaException e) {
                e.printStackTrace();
            }

            IVista visualizador;
            if (juego.jugadorActualTieneEjercitos()) {
                visualizador = new VisualizadorColocar(juego, contenedorJuego, this.visualizadorFaseColocar);

            } else {
                visualizador = new VisualizadorFaseColocar(juego, contenedorJuego);
            }
            visualizador.visualizar();
        }
    }
    private void verificarEntradaDeTexto(TextField texto) {
        if(!texto.getText().matches("\\d+")) {
            texto.setText("");
        }
    }
}
