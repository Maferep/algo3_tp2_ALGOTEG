package edu.fiuba.algo3.modelo;

import java.util.stream.IntStream;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaInicioSinCompletar implements IEstrategiaFase {

    IEstrategiaFase estrategiaActualizada = this;

    @Override
    public IEstrategiaFase actualizar() {
        // TODO Auto-generated method stub
        return estrategiaActualizada;
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException{
        // TODO Auto-generated method stub
        throw new FaseIncompletaException(null);
    }

    @Override
    public Boolean finDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void realizar() throws Exception {
        agregarEjercitos(3);
        agregarEjercitos(5);
        estrategiaActualizada = new EstrategiaJuegoInicializado();
    }

    private void agregarEjercitos(int cantidad) {
        IntStream.of(cantidad).forEach(() -> {
            Jugador j = new Jugador();
        });
    }
}
