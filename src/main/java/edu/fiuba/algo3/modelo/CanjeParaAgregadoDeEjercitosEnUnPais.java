package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;

public class CanjeParaAgregadoDeEjercitosEnUnPais implements ICanje {
    static int ejercitosParaAgregarPorCanje = 2;
    Boolean encontroTarjeta = false;

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException {
        for(int i = 0 ; i < jugador.obtenerPaises().size() ; i++) {
            if(jugador.obtenerPaises().get(i).obtenerNombre().equals(tarjeta.obtenerPais().obtenerNombre())) {
                jugador.obtenerPaises().get(i).agregarEjercitos(ejercitosParaAgregarPorCanje);
                encontroTarjeta = true;
            }
        }
        if(!encontroTarjeta) {
            throw new NoExisteTarjetaException("No tienes ese pais para agregar fichas");
        }
    }
}
