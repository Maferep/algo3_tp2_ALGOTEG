package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.vista.VistaTarjetasSimbolos;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class SeleccionarTarjetaEventHandler implements EventHandler<ActionEvent> {
    Juego juego;
    Tarjeta tarjeta;
    List<Tarjeta> tarjetasUsadas;
    Button tarjetaBtn;
    VistaTarjetasSimbolos vista;

    public SeleccionarTarjetaEventHandler(Juego juego, Tarjeta tarjeta, List<Tarjeta> tarjetas, Button tarjetaBtn, VistaTarjetasSimbolos vista) {
        this.tarjeta = tarjeta;
        this.tarjetasUsadas = tarjetas;
        this.tarjetaBtn = tarjetaBtn;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tarjetasUsadas.add(tarjeta);
        tarjetaBtn.setDisable(true);

        if (tarjetasUsadas.size() == 3) {
            try {
                juego.realizarCanje(tarjetasUsadas);
            } catch (NoSePuedeProducirCanjeException e) {
                vista.mostrarAlerta();
            } catch (EjercitosException e) {
                e.printStackTrace();
            }
            vista.desactivarBotones();
        }
    }
}
