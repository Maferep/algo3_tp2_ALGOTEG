package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

public class TurnoMockUnJugadorPorPais implements ITurno {
    List<IJugador> s;
    int indice = 0;

    public TurnoMockUnJugadorPorPais(List<IPais> paises) throws EjercitosException {
        s = paises.stream().map(p -> inicializar(p)).collect(Collectors.toList());
    }

    public IJugador inicializar(IPais pais) {
        IJugador j = new Jugador(pais.obtenerNombre() + "Conq");
        j.asignarPais(pais);
        return j;
    }

    public IJugador jugadorActual() {
        return s.get(indice);
    }

    @Override
    public void siguienteJugador() {
        indice = (indice + 1) % s.size();
    }

    @Override
    public int cantidadDeJugadores() {
        return s.size();
    }

    @Override
    public boolean esUltimoJugador() {
        // TODO Auto-generated method stub
        return false;
    }
    public IJugador jugadorDeColor(String color) throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> obtenerColores() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int buscarIndiceDeJugador(IJugador jugador){
        return 0;
    }
    
}