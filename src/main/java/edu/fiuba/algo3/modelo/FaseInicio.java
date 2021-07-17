package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.builders.*;

import java.util.ArrayList;
import java.util.List;


public class FaseInicio implements IFase {
    List<Jugador> colores;
    List<Jugador> jugadores;
    IJugadorBuilder jugadorBuilder = new JugadorBuilder();

    //puede ser
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();

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
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() {
        // TODO Auto-generated method stub
        return estrategia.siguienteFase();
    }

    @Override
    public Boolean finDeJuego() {
        // devuelve si ha terminado el juego
        return estrategia.finDeJuego();
    }

    @Override
    public void realizar() {
        // Aqui realizo acciones que podrian cambiar la fase en la que estoy
        
    }

}
