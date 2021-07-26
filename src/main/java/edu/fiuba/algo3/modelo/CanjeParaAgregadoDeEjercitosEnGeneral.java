package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.ArrayList;
import java.util.List;

public class CanjeParaAgregadoDeEjercitosEnGeneral implements ICanje {

    //Asimismo, si un jugador posee tres tarjetas de país con el mismo símbolo o
    //tres símbolos distintos puede solicitar un canje según la siguiente tabla:

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError {

    }
}
