package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Tarjeta {
    static int ejercitosParaAgregarPorCanje = 2;
    IPais pais;
    Tarjeta(IPais pais) {
        this.pais = pais;
    }
	public IPais obtenerPais() {
		return pais;
	}

    public void activarTarjeta(IJugador jugador) {
        for(int i = 0 ; i < jugador.obtenerPaises().size() ; i++) {
            if(jugador.obtenerPaises().get(i).obtenerNombre().equals(pais.obtenerNombre())) {
                jugador.obtenerPaises().get(i).agregarEjercitos(ejercitosParaAgregarPorCanje);

            }
        }
    }
}
