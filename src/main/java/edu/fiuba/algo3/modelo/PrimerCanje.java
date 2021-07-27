package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.INumeroDeCanje;

public class PrimerCanje implements INumeroDeCanje {

    static int cantidad = 4;

    public int cantidadDeSoldadosParaCanjear() {
        return cantidad;
    }

    public INumeroDeCanje actualizar() {
        return new SegundoCanje();
    }
}
