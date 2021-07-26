package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.fases.FaseInicio;

public class Turno implements ITurno {
    private LinkedList<IJugador> jugadores = new LinkedList<IJugador>();
    public List<IJugador> listaJugadores = new LinkedList<IJugador>();
    List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    int cantidadEjercitos = 8;

    public Turno(List<String> colores, int cantidad, Mazo mazo) throws EjercitosException {
        listaJugadores = construirJugadores(colores, cantidad, mazo);
        this.jugadores.addAll(listaJugadores);
        definirPrimerJugador(listaJugadores.get((int) (Math.random() % listaJugadores.size())));
    }

    private void definirPrimerJugador(IJugador iJugador) {
        while (jugadorActual() != iJugador)
            siguienteJugador();
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
        asignarSistemaDeCanje(mazo,jugadores);
        asignarPaisesAleatoriamente(paises, jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }

    public void asignarSistemaDeCanje(Mazo mazo, List<IJugador> jugadores) {
        for(int i = 0 ; i < jugadores.size() ; i++) {
            jugadores.get(i).asignarCanje(mazo);
        }
    }

    private List<IJugador> jugadoresDeColores(List<String> colores) {
        return colores.stream()
                .map(c -> new Jugador(c))
                .collect(Collectors.toList());
    }

    /*
    Asigna aleatoriamente paises de la lista recibida a los jugadores.
    No verifica que las listas estén vacías.
    Preserva el orden de la lista de jugadores, no de la de paises.
    */ 
    public void asignarPaisesAleatoriamente(List<IPais> paises, List<IJugador> jugadores) {
        Collections.shuffle(paises);
        for (int i = 0; i < paises.size(); i++) {
            IPais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).inicializarPais(actual);
        }
    }

    public void asignarEjercitosAJugadores(List<IJugador> jugadores) throws EjercitosException {
        for (IJugador j : jugadores) {
            j.inicializarEjercitos(cantidadEjercitos);
        }
    }
}
