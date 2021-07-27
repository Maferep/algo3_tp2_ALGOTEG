package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.INumeroDeCanje;

public class TercerCanje implements INumeroDeCanje {

    static int cantidad = 10;
    static int numeroInicial = 4;

    public int cantidadDeSoldadosParaCanjear() {
        return cantidad;
    }

    public INumeroDeCanje actualizar() {
        return new CuartoCanjeOMayor(numeroInicial);
    }
}
