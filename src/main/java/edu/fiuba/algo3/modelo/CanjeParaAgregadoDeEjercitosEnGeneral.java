package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanjeParaAgregadoDeEjercitosEnGeneral implements ICanje {

    Tarjetas tarjetasNuevas = new Tarjetas();

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        tarjetasNuevas.agregarTarjeta(tarjeta);
        if(this.verificarPosibilidadDeCanje()) {
            this.realizarCanje(jugador);
        }
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
        tarjetasNuevas.usarTarjetas();
    }

    public int determinarCantidadDeEjercitos() {
        return 1;
    }

    //Clase canje en Juego
    //Clase canje tenga un diccionario de jugadores que hicieron canje
    //Verificacion de cantidad de canjes desde canje

}
