package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class CanjePais implements ICanje {

    static int ejercitosParaAgregarPorCanje = 2;

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) {
        for(int i = 0 ; i < jugador.obtenerPaises().size() ; i++) {
            if(jugador.obtenerPaises().get(i).obtenerNombre().equals(tarjeta.obtenerPais().obtenerNombre())) {
                realizarCanje(jugador, jugador.obtenerPaises().get(i), tarjeta);
            }
        }
    }

    public void realizarCanje(IJugador jugador, IPais pais, Tarjeta tarjeta) {
        pais.agregarEjercitos(ejercitosParaAgregarPorCanje);
        jugador.obtenerMazo().insertarAlFondoDelMazo(tarjeta);
        jugador.obtenerTarjetas().remove(tarjeta);
    }
}
