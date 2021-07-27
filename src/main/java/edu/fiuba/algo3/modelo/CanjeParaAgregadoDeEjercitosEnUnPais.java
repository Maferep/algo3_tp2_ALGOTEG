package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class CanjeParaAgregadoDeEjercitosEnUnPais implements ICanje {

    static int ejercitosParaAgregarPorCanje = 2;

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) {
        for(int i = 0 ; i < jugador.obtenerPaises().size() ; i++) {
            if(jugador.obtenerPaises().get(i).obtenerNombre().equals(tarjeta.obtenerPais().obtenerNombre())) {
                jugador.obtenerPaises().get(i).agregarEjercitos(ejercitosParaAgregarPorCanje);
            }
        }
    }
}
