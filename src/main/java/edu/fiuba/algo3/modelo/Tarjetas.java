package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import java.util.LinkedList;

public class Tarjetas {

    public static int cantidadEstipulada = 3;

    public LinkedList<Tarjeta> tarjetas = new LinkedList<Tarjeta>();
    public LinkedList<String> simbolos = new LinkedList<String>();
    public LinkedList<String> otraListaDeSimbolos = new LinkedList<String>();

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
        simbolos.add(tarjeta.obtenerSimbolo().obtenerSimbolo());
        otraListaDeSimbolos.add(tarjeta.obtenerSimbolo().obtenerSimbolo());
    }

    public boolean verificarIgualdad(LinkedList<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException {
        String simboloDeReferencia = tarjetas.peekFirst().obtenerSimbolo().obtenerSimbolo();
        String otroSimboloDeReferencia = tarjetas.peekLast().obtenerSimbolo().obtenerSimbolo();
        if(tarjetas.peekFirst().obtenerSimbolo().sonIgualesA(simboloDeReferencia, simbolos)) {
            limpiarListas();
            return true;
        }
        simbolos.removeFirst();
        otraListaDeSimbolos.removeLast();
        if(tarjetas.peekFirst().obtenerSimbolo().noSonIgualesA(simboloDeReferencia, otroSimboloDeReferencia, simbolos, otraListaDeSimbolos)) {
            limpiarListas();
            return true;
        }
        throw new NoSePuedeProducirCanjeException("No se puede producir el canje ya que no existen " +
                "tarjetas con simbolos o todos diferentes o todos iguales");
    }

    public void limpiarListas() {
        simbolos.clear();
        otraListaDeSimbolos.clear();
    }

    public void usarTarjetas() {
        tarjetas.clear();
    }

    public boolean existeCantidadValidaDeTarjetas() {
        return (tarjetas.size() == cantidadEstipulada);
    }
}
