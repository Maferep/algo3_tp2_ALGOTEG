package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.LinkedList;

public class CanjeSimbolos implements ICanje {

    Tarjetas tarjetasNuevas = new Tarjetas();

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        tarjetasNuevas.agregarTarjeta(tarjeta);
        this.verificarPosibilidadDeCanje();
        this.realizarCanje(jugador);
    }

    private void verificarPosibilidadDeCanje() throws NoSePuedeProducirCanjeException {
        if(!tarjetasNuevas.existeCantidadValidaDeTarjetas() 
            || !verificarIgualdad(tarjetasNuevas.tarjetas)) 
            throw new NoSePuedeProducirCanjeException(null);
    }

    private boolean verificarIgualdad(LinkedList<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException {
        return tarjetasNuevas.verificarIgualdad(tarjetas);
    }

    private void realizarCanje(IJugador jugador) throws EjercitosException {
        jugador.agregarNuevosEjercitos(determinarCantidadDeEjercitos(jugador));
        for(int i = 0 ; i < tarjetasNuevas.tarjetas.size() ; i++) {
            jugador.obtenerMazo().insertarAlFondoDelMazo(tarjetasNuevas.tarjetas.get(i));
            jugador.obtenerTarjetas().remove(tarjetasNuevas.tarjetas.get(i));
        }
        tarjetasNuevas.usarTarjetas();
        jugador.actualizarNumeroDeCanje();
    }

    private int determinarCantidadDeEjercitos(IJugador jugadorActual) {
        return jugadorActual.obtenerNumeroDeCanje().cantidadDeSoldadosParaCanjear();
    }

}
