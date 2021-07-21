package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseAtacar extends FaseAbstracta {
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

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        return this;
    }

}
