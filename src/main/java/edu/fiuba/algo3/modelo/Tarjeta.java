package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;

public class Tarjeta {
    IPais pais;
    Simbolo simbolo;

    public Tarjeta(IPais pais, Simbolo simboloDeTarjeta) {
        this.pais = pais;
        this.simbolo = simboloDeTarjeta;
    }

    public IPais obtenerPais() {
        return pais;
    }
    public Simbolo obtenerSimbolo() {
        return simbolo;
    }

    public void activar() {
        int cantidadEjercitos = 2;
        pais.agregarEjercitos(cantidadEjercitos);
    }

}
