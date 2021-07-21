package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class FaseAtacar implements IFase {
    List<Pais> paises;
    Turno turno;
    //No usa estrtegias pues puede terminar sin hacer nada

    public FaseAtacar(IFase faseAnterior) {
    }

    @Override
    public Boolean faseCompletada() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO el juego no termina aqui, es para probar tests
        return true;
    }

    public void atacar(Pais atacante, int cantidadDeSoldados, Pais defensor) throws Exception {
        atacante.atacar(defensor, cantidadDeSoldados);
    }

    public FaseInicio asFaseInicio() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase atacar");
    }

    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        return this;
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase atacar");
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase atacar");
    }

}
