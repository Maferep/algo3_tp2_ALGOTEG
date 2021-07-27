package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.INumeroDeCanje;

public class SegundoCanje implements INumeroDeCanje {

    static int cantidad = 7;

    public int cantidadDeSoldadosParaCanjear() {
        return cantidad;
    }

    public INumeroDeCanje actualizar() {
        return new TercerCanje();
    }
}
