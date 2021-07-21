package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class FaseAtacar implements IFase {
    List<Pais> paises;
    Turno turno;
    //No usa estrtegias pues puede terminar sin hacer nada

    public FaseAtacar(Turno turno, List<Pais> paises) {
        this.turno = turno;
        this.paises = paises;
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        return new FaseReagrupar(turno, paises);
    }

    @Override
    public Boolean esFinDeJuego() {
        return false;
    }

    public void atacar(Pais atacante, int cantidadDeSoldados, Pais defensor) throws Exception {
        //TODO: validar existencia de paises y turno correcto
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
