package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

public class Tarjeta {
    IPais pais;
    Simbolo simbolo;

    public Tarjeta(IPais pais, Simbolo simboloDeTarjeta) {
        this.pais = pais;
        this.simbolo = simboloDeTarjeta;
    }

    public void activarTarjeta(IJugador jugador, ICanje tipoDeCanje) throws NoExisteTarjetaException, PaisNoExistenteError {
        tipoDeCanje.activarTarjeta(jugador, this);
    }

    public IPais obtenerPais() {
        return pais;
    }

    public IPais obtenerSimbolo() {
        return pais;
    }

}
