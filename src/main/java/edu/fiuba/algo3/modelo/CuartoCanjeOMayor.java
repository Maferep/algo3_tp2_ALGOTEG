package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.INumeroDeCanje;

public class CuartoCanjeOMayor implements INumeroDeCanje {

    int numero = 0;

    public CuartoCanjeOMayor(int numeroInicial) {
        numero = numeroInicial;
    }

    public int cantidadDeSoldadosParaCanjear() {
        return ((numero-1) * 5);
    }

    public INumeroDeCanje actualizar() {
        return new CuartoCanjeOMayor((numero + 1));
    }
}
