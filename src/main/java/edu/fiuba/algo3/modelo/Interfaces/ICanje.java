package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

public interface ICanje {
    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError;
}
