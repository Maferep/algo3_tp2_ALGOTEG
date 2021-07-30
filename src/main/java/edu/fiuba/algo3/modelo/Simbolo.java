package edu.fiuba.algo3.modelo;

public class Simbolo {

    public String simbolo;

    public Simbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Boolean esIgualA(Simbolo otroSimbolo) {
        return this.simbolo.equals(otroSimbolo.simbolo);
    }
    
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Simbolo)) return false;
        return ((Simbolo) object).esIgualA(this);
    }
}
