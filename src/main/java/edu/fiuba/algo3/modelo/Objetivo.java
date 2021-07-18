package edu.fiuba.algo3.modelo;

public class Objetivo {

    static int minimoPaises = 30;

    //objetivo general
    public boolean objetivoGeneralCumplido(Jugador jugadorActual) {
        return (jugadorActual.paises.size() >= minimoPaises);
    }

    //objetivo especifico


}
