package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseColocar implements IFase {

    private List<Pais> paises;
    private Turno turno;

    public FaseColocar(Turno turno, List<Pais> paises) {
        this.turno = turno;
        this.paises = paises;
    }

    //métodos de colocar


    //métodos de IFase

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        turno.siguienteJugador();
        return new FaseAtacar(turno, paises);
    }

    @Override
    public Boolean esFinDeJuego() {
        return false;
    }

    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase colocar");
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        return this;
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase colocar");
    }

    @Override
    public FaseReagruparConConquista asFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException("Estamos en fase colocar");
    }

}
