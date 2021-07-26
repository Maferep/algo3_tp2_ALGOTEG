package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;

public interface ITarjeta {

    public IPais obtenerPais();
    public void activarTarjeta(IJugador jugador) throws NoExisteTarjetaException;

}
