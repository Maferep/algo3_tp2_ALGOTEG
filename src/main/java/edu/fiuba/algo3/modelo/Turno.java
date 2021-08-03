package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TODO corregir posicion de la clase!!
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.fases.FaseInicio;

public class Turno implements ITurno {
    private LinkedList<IJugador> jugadores = new LinkedList<IJugador>();
    private IJugador primero;
    Mapa mapa = new Mapa();
    int cantidadEjercitos = 8;

    public Turno(List<String> colores, int cantidad, Mazo mazo) throws EjercitosException {
        List<IJugador> listaJugadores = construirJugadores(colores, cantidad, mazo);
        this.jugadores.addAll(listaJugadores);
        definirPrimerJugador(listaJugadores.get((int) (Math.random() % listaJugadores.size())));
    }

    private void definirPrimerJugador(IJugador iJugador) {
        while (jugadorActual() != iJugador)
            siguienteJugador();
        primero = jugadorActual();
    }

    //Cuando termino una fase, el jugador se me queda siendo el ultimo. Por lo que siempre
    //va a ser true el esUltimoJugador() y nunca voy a poder apretar el boton sigJugador

    public void actualizarListaDeJugadoresAlCambiarDeFase() {
        this.siguienteJugador();
    }

    public IJugador jugadorActual() {
        return jugadores.peekFirst();
    }

    public int buscarIndiceDeJugador(IJugador jugador){
        int index  = IntStream.range(0, jugadores.size())
                .filter(userInd-> jugadores.get(userInd).obtenerColor().equals(jugador.obtenerColor()))
                .findFirst().orElse(-1);
        return index;
    }

    public void siguienteJugador() {
        IJugador j = jugadores.removeFirst();
        jugadores.add(j);
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    public static IFase crear(int cantJugadores) throws Exception {
        return new FaseInicio(cantJugadores);
    }

    public List<IJugador> construirJugadores(List<String> colores, int cantidad, Mazo mazo) throws EjercitosException {
        List<IJugador> jugadores = jugadoresDeColores(colores.subList(0, cantidad));
        mapa.asignarPaises(jugadores, new OrdenadorAleatorio());
        asignarSistemaDeCanje(mazo,jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }

    public void asignarSistemaDeCanje(Mazo mazo, List<IJugador> jugadores) {
        
    }

    private List<IJugador> jugadoresDeColores(List<String> colores) {
        return colores.stream()
                .map(c -> new Jugador(c))
                .collect(Collectors.toList());
    }

    public void asignarEjercitosAJugadores(List<IJugador> jugadores) throws EjercitosException {
        for (IJugador j : jugadores) {
            j.inicializarEjercitos(cantidadEjercitos);
        }
    }

    @Override
    //Devuelve el jugador de ese color o tira una excepción NoSuchElementException.
    public IJugador jugadorDeColor(String color) throws NoSuchElementException{
        return jugadores.stream().filter(j -> j.obtenerColor() == color).findAny().get();
    }

    @Override
    //Devuelve true si es el jugador anterior al primero.
    public boolean esUltimoJugador() {
        int indiceUltimo = (jugadores.indexOf(primero) - 1);
        if(indiceUltimo < 0) indiceUltimo += jugadores.size();
        return jugadorActual().equals(jugadores.get(indiceUltimo));
    }

    @Override
    public List<String> obtenerColores() {
        return jugadores.stream()
            .map(j -> j.obtenerColor())
            .collect(Collectors.toList());
    }

    @Override
    public IJugador obtenerGanador() {
        return jugadores
            .stream()
            .filter(jugador -> jugador.cumplioObjetivo())
            .findFirst()
            .get();
    }
}
