package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class FaseAtacar extends FaseAbstracta {
    IEstrategiaFase estrategia = new EstrategiaAtaqueSinConquista();
    Boolean finDeJuego = false;

    public FaseAtacar(ITurno turno, IMapa mapa) {
        this.turno = turno;
        this.mapa = mapa;
    }

    public IFase faseActual() {
        return this;
    }

    public ITurno turno() {
        return turno;
    }

    // métodos públicos

    public void atacar(IPais atacante, int cantidadDeSoldados, IPais defensor) throws Exception {
        //TODO: validar existencia de paises y turno correcto
        atacante.atacar(defensor, cantidadDeSoldados);
        //TODO: corregir if ambiguo
        if(defensor.obtenerConquistador() == atacante.obtenerConquistador())
            estrategia = estrategia.turnoCompleto(turno);
    }

    public void atacarConAtaque(Ataque tipoAtaque) throws Exception {
        //TODO: validar existencia de paises y turno correcto
        tipoAtaque.atacar();
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase(IFabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException,
            TurnoException {
        return estrategia.siguienteFase(turno, fabrica);
    }

    @Override
    public Boolean esFinDeJuego() {
        return finDeJuego;
    }

    @Override
    public FaseAtacar obtenerFaseAtacar() {
        return this;
    }

    @Override
    public void siguienteTurno() throws TurnoException, FaseIncompletaException {
        estrategia.siguienteJugador(turno);
    }

    

}
