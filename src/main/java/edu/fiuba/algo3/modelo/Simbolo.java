package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import java.util.List;

public class Simbolo {

    String simbolo;

    public Simbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String obtenerSimbolo() {
        return simbolo;
    }

    public boolean sonIgualesA(String simbolo, LinkedList<String> simbolos) {
        return (simbolos.stream().allMatch(j -> j.equals(simbolo)));
    }

    public boolean noSonIgualesA(String simbolo,String otroSimboloDeReferencia, LinkedList<String> simbolos, LinkedList<String> otraListaDeSimbolos ) {
        return (simbolos.stream().noneMatch(j -> j.equals(simbolo)) && (otraListaDeSimbolos.stream().noneMatch(j -> j.equals(otroSimboloDeReferencia))));
    }
}
