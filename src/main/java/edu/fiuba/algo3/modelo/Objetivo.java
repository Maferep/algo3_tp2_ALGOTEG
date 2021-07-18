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
        for(int i = 0 ; i < paises.size() ; i++) {
            if(paises.get(i).conquistador.color.equals(jugadorADestruir.color)) {
                return false;
            }
        }
        return true;
    }


}
