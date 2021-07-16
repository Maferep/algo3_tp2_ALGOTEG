package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.builders.*;

import java.util.ArrayList;
import java.util.List;


public class FaseInicio implements IFaseInicio {
    List<Jugador> colores;
    List<Jugador> jugadores;
    IJugadorBuilder jugadorBuilder = new JugadorBuilder();
    IEstrategiaInicio estrategia = new EstrategiaInicio();

    public FaseInicio(int cantJugadores) {
        jugadores = new ArrayList<Jugador>();
        for(int i = 0; i < cantJugadores; i++){
            jugadores.add(jugadorBuilder.crearJugador());
        }
    }

    @Override
    public Integer cantidadDeJugadores() {
        return jugadores.size();
    }

    @Override
    public void asignarColores() {
        // TODO Auto-generated method stub
        estrategia.asignarColores();
        estrategia = estrategia.actualizar();

    }

    @Override
    public void ubicarEjercitos(int cantEjercitos) {
        estrategia.ubicarEjercitos(cantEjercitos);
        estrategia = estrategia.actualizar();

    }

    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

























    @Override
    public IFase siguienteFase() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean finDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void realizar() {
        // TODO Auto-generated method stub

    }

}
