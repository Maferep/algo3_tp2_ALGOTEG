package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EtapaInicial implements IFase {
    List<Jugador> jugadores;
    List<String> colores = Arrays.asList("Azul", "Rojo", "Amarillo", "Verde", "Rosa", "Negro");
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();
    
    
    
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;
    static int cantidadEjercitos = 8; // la cantidad de ejercitos para cada jugador en la etapa inicial es 8
    static int cantidadInicial = 0;

    // para que pasen los test hago una lista de paises random
    List<Pais> paises = Arrays.asList("Puerto Rico", "Colombia", "Venezuela", "Honduras", "Guayana", "Guatemala")
            .stream().map(n -> new Pais(n)).collect(Collectors.toList());

    public EtapaInicial(int cantidadJugadores) throws Exception {
        if (cantidadJugadores < minimoJugadores || cantidadJugadores > maximoJugadores)
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + (minimoJugadores) + "y un máximo de"
                    + (maximoJugadores) + "jugadores.");
        asignarJugadores(cantidadJugadores);
        // asignarTurnosAleatoriamente();
        asignarPaisesAleatoriamenteAJugadores();
        asignarEjercitosAJugadores();
    }

    private void asignarJugadores(int cantidadJugadores) {
        jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugador = new Jugador(colores.get(i));
            jugadores.add(jugador);
        }
    }

    private void asignarTurnosAleatoriamente() {

    }

    // se va a tener que leer el archivo de paises e ir cargandose en la lista en la
    // etapa inicial.

    private void asignarPaisesAleatoriamenteAJugadores() {
        for (int i = 0; i < paises.size(); i++) {
            jugadores.get(i % cantidadDeJugadores()).asignarPais(paises.get(i));
        }
    }

    private void asignarEjercitosAJugadores() throws Exception {
        for (int i = 0; i < cantidadDeJugadores(); i++) {
            (jugadores.get(i)).agregarEjercitos(cantidadEjercitos);
        }
    }

    int cantidadDeJugadores() {
        return jugadores.size();
    }

    Jugador jugadores(int i) throws Exception {
        if (i < cantidadInicial || i > cantidadDeJugadores())
            throw new CantidadDeJugadoresError("No puedes tener una cantidad de jugadores menor a" + cantidadInicial
                    + "ni mayor a" + cantidadDeJugadores());
        return jugadores.get(i);
    }

    @Override
    public Boolean faseCompletada() {
        return estrategia.faseCompletada();
    }

    @Override
    public IFase siguienteFase() throws FaseIncompletaException {
        return estrategia.siguienteFase(this);
    }

    @Override
    public void realizar() throws Exception {
        asignarTurnosAleatoriamente();
        asignarPaisesAleatoriamenteAJugadores();
        asignarEjercitosAJugadores();

        estrategia = estrategia.actualizar();
    }

    @Override
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return null;
    }

}
