package edu.fiuba.algo3.modelo.excepciones;

public class PaisNoExistenteException extends AlgoTegException {

    private static final long serialVersionUID = -8618114065857941861L;
    public PaisNoExistenteException(String msg) {
        super(msg);
    }
}
