package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteException;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.VisualizadorColocarParaFaseInicio;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class BotonColocarParaFaseInicioEventHandler implements EventHandler<ActionEvent> {
    IPais pais;
    Juego juego;
    TextField campoEjercitos;
    ContenedorJuego contenedorJuego;
    IVista visualizadorFaseInicio;
    Label texto;

    public BotonColocarParaFaseInicioEventHandler(IPais pais, Juego juego, TextField campo, Label texto, ContenedorJuego contenedorJuego, IVista visualizadorFaseInicio) {
        this.pais = pais;
        this.juego = juego;
        this.campoEjercitos = campo;
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
        this.texto = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int ingresoUsuario = 0;
        this.verificarEntradaDeTexto(this.campoEjercitos);
        if (campoEjercitos.getText().isEmpty()) {
            this.texto.setText("Debe ingresar una cantidad de ejercitos");
            this.campoEjercitos.requestFocus();
        }
        else {
            ingresoUsuario = Integer.parseInt(campoEjercitos.getText());
            try {
                juego.ubicarEjercitosEnPais(ingresoUsuario, pais);
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

            VisualizadorColocarParaFaseInicio visualizadorColocarParaFaseInicio = new VisualizadorColocarParaFaseInicio(juego, contenedorJuego, this.visualizadorFaseInicio);
            visualizadorColocarParaFaseInicio.visualizar();
        }
    }
    private void verificarEntradaDeTexto(TextField texto) {
        if(!texto.getText().matches("\\d+")) {
            texto.setText("");
        }
    }
}
