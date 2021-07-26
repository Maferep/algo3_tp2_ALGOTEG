package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;

public class CanjeParaAgregadoDeEjercitosEnUnPais implements ICanje {
    static int ejercitosParaAgregarPorCanje = 2;
    IPais pais;

    Boolean encontroTarjeta = false;

    CanjeParaAgregadoDeEjercitosEnUnPais(IPais pais) {
        this.pais = pais;
    }

    public IPais obtenerPais() {
        return pais;
    }

    public void activarTarjeta(IJugador jugador) throws NoExisteTarjetaException {
        for(int i = 0 ; i < jugador.obtenerPaises().size() ; i++) {
            if(jugador.obtenerPaises().get(i).obtenerNombre().equals(pais.obtenerNombre())) {
                jugador.obtenerPaises().get(i).agregarEjercitos(ejercitosParaAgregarPorCanje);
                encontroTarjeta = true;
            }
        }
        if(!encontroTarjeta) {
            throw new NoExisteTarjetaException("No tienes ese pais para agregar fichas");
        }
    }
}
