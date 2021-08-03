package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.AdyacenciaException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
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
    private IVistaFases fase;

    public VistaVerificarEjercitos(Juego juego, ContenedorJuego contenedorJuego, IPais pais, IPais adyacente,
            TextField campoEjercitos, Button botonVolver, IVistaFases fase) {

        this.contenedorJuego = contenedorJuego;
        this.botonVolver = botonVolver;
        this.campoEjercitos = campoEjercitos;
        this.juego = juego;
        this.pais = pais;
        this.adyacente = adyacente;
        this.fase = fase;

    }

    @Override
    public void visualizar() {
        Label texto = new Label();
        
        this.verificarEntradaDeTexto(campoEjercitos);
        if (campoEjercitos.getText().trim().equals("")) {
            imprimirFracaso(texto, "Debe ingresar un número de ejércitos");
            return;
        }
        int cantidadDeEjercitos = Integer.parseInt(campoEjercitos.getText());

        try {
            juego.transferirEjercitos(cantidadDeEjercitos, pais, adyacente);
        } catch (TransferirEjercitosException e) {
            imprimirFracaso(texto, "Numero de ejercitos es invalido!");
            return;
        } catch (FaseErroneaException | AdyacenciaException e) {
            System.exit(-1);
        } ;
        fase.visualizar();
        
    }

    private void imprimirFracaso(Label texto, String mensaje) {
        texto.setText("Numero de ejercitos es invalido!");
        campoEjercitos.requestFocus();
        contenedorJuego.agregarABotonera(texto);
    }

    private void verificarEntradaDeTexto(TextField texto) {
        if(!texto.getText().matches("\\d+")) 
            texto.setText("");
        
    }
}
