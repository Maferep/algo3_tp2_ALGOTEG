package edu.fiuba.algo3.modelo.excepciones;

public class PaisNoExistenteError extends Exception {

    private static final long serialVersionUID = -8618114065857941861L;
    public PaisNoExistenteError(String msg) {
        super(msg);
    }
}
