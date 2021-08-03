package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.AdyacenciaException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VistaVerificarEjercitos implements IVista {

    Button botonVolver;
    ContenedorJuego contenedorJuego;
    private TextField campoEjercitos;
    private Juego juego;
    private IPais pais;
    private IPais adyacente;
    public VistaVerificarEjercitos(
        Juego juego, ContenedorJuego contenedorJuego, IPais pais, IPais adyacente,
            TextField campoEjercitos, Button botonVolver) {

        this.contenedorJuego = contenedorJuego;
        this.botonVolver = botonVolver;
        this.campoEjercitos = campoEjercitos;
        this.juego = juego;
        this.pais = pais;
        this.adyacente = adyacente;
        
	}

	@Override
    public void visualizar() {
        Label texto = new Label("default!");
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
            campoEjercitos.requestFocus();
            return;
        } catch (FaseErroneaException e) {
            System.exit(-1);
        } catch (AdyacenciaException e) {
            e.printStackTrace();
        }
        contenedorJuego.limpiarBotonera();
        contenedorJuego.agregarABotonera(botonVolver);
        
    }

    private void verificarEntradaDeTexto(TextField texto) {
        if(!texto.getText().matches("\\d+")) 
            texto.setText("");
        
    }
}
