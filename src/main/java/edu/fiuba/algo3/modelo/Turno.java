package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.Collectors;

import edu.fiuba.algo3.OrdenadorAleatorio;
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.fases.FaseInicio;

public class Turno implements ITurno {
    private LinkedList<IJugador> jugadores = new LinkedList<IJugador>();
    private List<IJugador> listaJugadores = new LinkedList<IJugador>();
    private IJugador primero;
    Mapa mapa = new Mapa();
    int cantidadEjercitos = 8;

    public Turno(List<String> colores, int cantidad, Mazo mazo) throws EjercitosException {
        listaJugadores = construirJugadores(colores, cantidad, mazo);
        this.jugadores.addAll(listaJugadores);
        definirPrimerJugador(listaJugadores.get((int) (Math.random() % listaJugadores.size())));
    }

    private void definirPrimerJugador(IJugador iJugador) {
        while (jugadorActual() != iJugador)
            siguienteJugador();
        primero = jugadorActual();
    }

    public IJugador jugadorActual() {
        return jugadores.peekFirst();
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
}
