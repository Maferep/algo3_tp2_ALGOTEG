package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

public interface ICanje {
    public void activarTarjeta(IJugador jugador) throws NoExisteTarjetaException, PaisNoExistenteError;
    public IPais obtenerPais();
}
