package edu.fiuba.algo3.modelo.excepciones;

public class TurnoException extends Exception{

    /**
     * renombrar a "JugadorException"
     */
    private static final long serialVersionUID = 42716148744455508L;

    public TurnoException(String msg) {
        super(msg);
    }

}
