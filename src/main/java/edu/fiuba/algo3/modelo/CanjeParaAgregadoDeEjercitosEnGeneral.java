package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.LinkedList;

public class CanjeParaAgregadoDeEjercitosEnGeneral implements ICanje {

    Tarjetas tarjetasNuevas = new Tarjetas();
    IJugador jugadorActual;

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        tarjetasNuevas.agregarTarjeta(tarjeta);
        if(this.verificarPosibilidadDeCanje()) {
            this.realizarCanje(jugador);
        }
        jugadorActual = jugador;
    }

    public boolean verificarPosibilidadDeCanje() throws NoSePuedeProducirCanjeException {
        if(tarjetasNuevas.existeCantidadValidaDeTarjetas()) {
            return verificarIgualdad(tarjetasNuevas.tarjetas);
        }
        return false;
    }

    public boolean verificarIgualdad(LinkedList<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException {
        return tarjetasNuevas.verificarIgualdad(tarjetas);
    }

    public void realizarCanje(IJugador jugador) throws EjercitosException {
        jugador.agregarNuevosEjercitos(determinarCantidadDeEjercitos());
        for(int i = 0 ; i < tarjetasNuevas.tarjetas.size() ; i++) {
            jugador.obtenerMazo().insertarAlFondoDelMazo(tarjetasNuevas.tarjetas.get(i));
            jugador.obtenerTarjetas().remove(tarjetasNuevas.tarjetas.get(i));
        }
        tarjetasNuevas.usarTarjetas();
        jugador.actualizarNumeroDeCanje();
    }

    public int determinarCantidadDeEjercitos() {
        return jugadorActual.obtenerNumeroDeCanje().cantidadDeSoldadosParaCanjear();
    }

}
