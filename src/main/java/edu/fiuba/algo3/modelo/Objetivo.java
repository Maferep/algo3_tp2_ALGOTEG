package edu.fiuba.algo3.modelo;

import java.util.List;

public class Objetivo {

    static int minimoPaises = 30;

    //objetivo general
    public boolean objetivoGeneralCumplido(Jugador jugadorActual) {
        return (jugadorActual.paises.size() >= minimoPaises);
    }

    //objetivo destruir ejercito
    public boolean objetivoDestruirEjercitoCumplido(Jugador jugadorADestruir, List<Pais> paises) {
        return jugadorADestruir.esDestruido(paises);
    }

    //seguir con el tema de los objetivos y refactorizar si es necesario.
}
