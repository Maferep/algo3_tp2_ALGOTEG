package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseReagruparConConquista implements IFase {

    private List<Pais> paises;
    private Turno turno;
    private Mazo mazo = new Mazo(null);

    public FaseReagruparConConquista(Turno turno, List<Pais> paises) {
        this.turno = turno;
        this.paises = paises;
        turno.jugadorActual().agregarTarjetaAleatoria(mazo.obtenerTarjeta());
    }
    //metodos de reagrupar 


    //metodos de IFase

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        return new FaseColocar(turno, paises);
    }

    @Override
    public Boolean esFinDeJuego() {
        return false;
    }

    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FaseReagruparConConquista asFaseReagrupar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        return null;
    }

}
