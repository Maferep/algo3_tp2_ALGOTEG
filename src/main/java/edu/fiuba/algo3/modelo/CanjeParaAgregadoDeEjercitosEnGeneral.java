package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.ArrayList;
import java.util.List;

public class CanjeParaAgregadoDeEjercitosEnGeneral implements ICanje {

    private List<Tarjeta> tarjetas;

    public void activarTarjeta(IJugador jugador, Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        this.agregarTarjeta(tarjeta);
        this.verificarPosibilidadDeCanje();
        this.realizarCanje(jugador);
        tarjetas.clear();
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public void verificarPosibilidadDeCanje() throws NoSePuedeProducirCanjeException {
        if(tarjetas.size() == 3) {
            verificarIgualdad(tarjetas);
        }
    }

    public boolean verificarIgualdad(List<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException {
        for(int i = 0 ; i < tarjetas.size() ; i++) {
            if(tarjetas.get(i).obtenerSimbolo().sonIgualesA(tarjetas.get(i).obtenerSimbolo(), tarjetas)) {
                return true;
            }
            else if(tarjetas.get(i).obtenerSimbolo().noSonIgualesA(tarjetas.get(i).obtenerSimbolo(), tarjetas)) {
                return true;
            }
        }
        throw new NoSePuedeProducirCanjeException("No se puede producir el canje ya que no existen " +
                    "tarjetas con simbolos o todos diferentes o todos iguales");
    }

    public void realizarCanje(IJugador jugador) throws EjercitosException {
        jugador.agregarNuevosEjercitos(determinarCantidadDeEjercitos());
    }

    public int determinarCantidadDeEjercitos() {
        return 0;
    }

    //Clase canje en Juego
    //Clase canje tenga un diccionario de jugadores que hicieron canje
    //Verificacion de cantidad de canjes desde canje

}
