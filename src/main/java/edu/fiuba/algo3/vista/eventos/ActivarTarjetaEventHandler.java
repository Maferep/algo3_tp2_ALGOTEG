package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActivarTarjetaEventHandler implements EventHandler<ActionEvent> {
    Tarjeta tarjeta;
    Juego juego;
    Button tarjetaBtn;

    public ActivarTarjetaEventHandler(Juego juego, Tarjeta tarjeta, Button tarjetaBtn) {
        this.tarjeta = tarjeta;
        this.juego = juego;
        this.tarjetaBtn = tarjetaBtn;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.activarTarjeta(tarjeta);
            tarjetaBtn.setDisable(true);
        } catch (NoExisteTarjetaException e) {
            e.printStackTrace();
        } catch (NoSePuedeProducirCanjeException e) {
            e.printStackTrace();
        } catch (PaisNoExistenteException e) {
            e.printStackTrace();
        }

    }
}
