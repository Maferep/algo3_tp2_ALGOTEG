package edu.fiuba.algo3.modelo.excepciones;

public class NoExisteTarjetaException extends Exception {

    private static final long serialVersionUID = -8618114065857941861L;

    public NoExisteTarjetaException(String msg) {
        super(msg);
    }
}
