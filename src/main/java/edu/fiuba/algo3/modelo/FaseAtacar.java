package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class FaseAtacar implements IFase {

    public FaseAtacar(IFase actual) {
	}

	@Override
    public Boolean faseCompletada() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void realizar() {
        // TODO Auto-generated method stub

    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO el juego no termina aqui, es para probar tests
        return true;
    }

}
