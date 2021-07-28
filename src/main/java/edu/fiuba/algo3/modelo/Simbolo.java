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

    public boolean sonIgualesA(String simbolo, List<String> simbolos) {
        return (simbolos.stream().allMatch(j -> j.equals(simbolo)));
    }

    public boolean noSonIgualesA(String simbolo,String otroSimboloDeReferencia, List<String> simbolos, List<String> otraListaDeSimbolos ) {
        return (simbolos.stream().noneMatch(j -> j.equals(simbolo)) && (otraListaDeSimbolos.stream().noneMatch(j -> j.equals(otroSimboloDeReferencia))));
    }
}
