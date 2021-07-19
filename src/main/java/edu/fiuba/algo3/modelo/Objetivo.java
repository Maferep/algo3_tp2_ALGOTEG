package edu.fiuba.algo3.modelo;

import java.util.List;

public class Objetivo {

    //objetivo general
    public boolean objetivoGeneralCumplido(Jugador jugadorActual) {
        return jugadorActual.tieneMinimoPaises();
    }

    //objetivo destruir ejercito
    public boolean objetivoDestruirEjercitoCumplido(Jugador jugadorADestruir, List<Pais> paises) {
        return jugadorADestruir.esDestruido(paises);
    }

    //objetivo conquistar paises y/o continentes

}
