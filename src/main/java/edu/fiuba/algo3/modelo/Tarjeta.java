package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;

public class Tarjeta implements ITarjeta{
    static int ejercitosParaAgregarPorCanje = 2;
    IPais pais;
    Boolean encontroTarjeta = false;
    Tarjeta(IPais pais) {
        this.pais = pais;
    }
    /*Tarjeta(IPais pais, Simbolo simbolo) {
        this.pais = pais;
    }*/
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

    //Asimismo, si un jugador posee tres tarjetas de país con el mismo símbolo o
    //tres símbolos distintos puede solicitar un canje según la siguiente tabla:
}
