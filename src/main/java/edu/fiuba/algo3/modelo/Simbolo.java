package edu.fiuba.algo3.modelo;

import java.util.List;

public class Simbolo {

    String simbolo;

    public Simbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String obtenerSimbolo() {
        return simbolo;
    }

    public boolean sonIgualesA(Simbolo simbolo , List<Tarjeta> tarjetas) {
        for(int i = 0 ; i < tarjetas.size() ; i++) {
            if(!simbolo.obtenerSimbolo().equals(tarjetas.get(i).obtenerSimbolo().simbolo)) {
                return false;
            }
        }
        return true;
    }

    public boolean noSonIgualesA(Simbolo simbolo , List<Tarjeta> tarjetas) {
        for(int i = 0 ; i < tarjetas.size() ; i++) {
            if(simbolo.obtenerSimbolo().equals(tarjetas.get(i).obtenerSimbolo().simbolo)) {
                return false;
            }
        }
        return true;
    }
}
