package edu.fiuba.algo3.modelo;

import java.util.List;

public class Simbolo {

    public String simbolo;

    public Simbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Boolean esIgualA(Simbolo otroSimbolo) {
        return this.simbolo.equals(otroSimbolo.simbolo);
    }
}
