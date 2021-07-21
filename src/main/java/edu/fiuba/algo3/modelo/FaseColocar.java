package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseAtacar;
import edu.fiuba.algo3.modelo.FaseInicio;
import edu.fiuba.algo3.modelo.Interfaces.IEstrategiaFase;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.Interfaces.IFase;

public class FaseColocar implements IFase {
    IEstrategiaFase estrategia = new EstrategiaColocarSinCompletar();

    //Cada jugador puede colocar tantos ejércitos como países domine, dividido 2.
    // Si el jugador controla menos de seis países de todas maneras incorpora tres ejércitos.
    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) {
        // TODO ubicarEjercitos
        //al 'terminar de ubicar nuevamente' la etapa colocar se considera completada
        estrategia = estrategia.actualizar();
    }

    // métodos de fase
    @Override
    public Boolean faseCompletada() {
        // TODO Auto-generated method stub
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        // TODO Auto-generated method stub
        return estrategia.siguienteFase(this);
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public FaseInicio asFaseInicio() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase colocar");
    }

    @Override
    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase colocar");
    }

    @Override
    public FaseColocar asFaseColocar() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException("Estamos en fase colocar");
    }

}
