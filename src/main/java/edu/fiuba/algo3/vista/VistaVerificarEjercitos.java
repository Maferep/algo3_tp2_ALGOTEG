package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VistaVerificarEjercitos implements IVista {

    Button botonVolver;
    ContenedorJuego contenedorJuego;
    public VistaVerificarEjercitos(
        Juego juego, ContenedorJuego contenedorJuego, IPais pais, IPais adyacente,
            TextField campoEjercitos, Button botonVolver) {

        this.contenedorJuego = contenedorJuego;
        this.botonVolver = botonVolver;

        Label texto = new Label();
        contenedorJuego.agregarABotonera(texto);
        this.verificarEntradaDeTexto(campoEjercitos);
        if (campoEjercitos.getText().trim().equals("")) {
            texto.setText("Debe ingresar jugadores");
            campoEjercitos.requestFocus();
            return;
        }
        int cantidadDeEjercitos = Integer.parseInt(campoEjercitos.getText());

        try {
            juego.transferirEjercitos(cantidadDeEjercitos, pais, adyacente);
        } catch (TransferirEjercitosException e) {
            texto.setText("Numero de ejercitos es invalido!");
            contenedorJuego.agregarABotonera(texto);
            return;
        } catch (FaseErroneaException e) {
            System.exit(-1);
        }
	}

	@Override
    public void visualizar() {
        contenedorJuego.limpiarBotonera();
        contenedorJuego.agregarABotonera(botonVolver);
        
    }

    private void verificarEntradaDeTexto(TextField texto) {
        if(!texto.getText().matches("\\d+")) 
            texto.setText("");
        
    }
}
