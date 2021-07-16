package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EtapaInicial {
    List<Jugador> jugadores;
    List<String> colores = Arrays.asList("Azul","Rojo","Amarillo","Verde","Rosa","Negro");
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;
    static int cantidadEjercitos = 8; //la cantidad de ejercitos para cada jugador en la etapa inicial es 8
    static int cantidadInicial = 0;

    //para que pasen los test hago una lista de paises random
    List<Pais> paises = Arrays.asList(
            "Puerto Rico",
            "Colombia",
            "Venezuela",
            "Honduras",
            "Guayana",
            "Guatemala")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    public EtapaInicial(int cantidadJugadores) throws Exception {
        if(cantidadJugadores < minimoJugadores || cantidadJugadores > maximoJugadores)
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + (minimoJugadores) + "y un máximo de" + (maximoJugadores) + "jugadores.");
        asignarJugadores(cantidadJugadores);
        //asignarTurnosAleatoriamente();
        asignarPaisesAleatoriamenteAJugadores();
        asignarEjercitosAJugadores();
    }

    public void asignarJugadores(int cantidadJugadores) {
        jugadores = new ArrayList<Jugador>();
        for(int i = 0 ; i < cantidadJugadores ; i++ ) {
            Jugador jugador = new Jugador(colores.get(i));
            jugadores.add(jugador);
        }
    }

    public void asignarTurnosAleatoriamente() throws Exception {
        Turno sistemaDeTurnos = new Turno();
        for(int i = 0 ; i < cantidadDeJugadores() ; i++) {
            jugadores(i).asignarNumeroParaTurno();
            //de menor a mayor: ascendente
            //tengo que ordenar la lista de menor a mayor.
           // sistemaDeTurnos.determinarTurnos(jugadores((int)(Math.random()*i)));
        }
        sistemaDeTurnos.determinarTurnos(jugadores);
    }

    //se va a tener que leer el archivo de paises e ir cargandose en la lista en la etapa inicial.

    public void asignarPaisesAleatoriamenteAJugadores() {
        for(int i = 0; i < paises.size(); i++){
            jugadores
                    .get(i % cantidadDeJugadores())
                    .asignarPais(paises.get(i));
        }
    }

    public void asignarEjercitosAJugadores() throws Exception {
        for(int i = 0 ; i < cantidadDeJugadores() ; i++ ) {
            (jugadores.get(i)).agregarEjercitos(cantidadEjercitos);
        }
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    public Jugador jugadores(int i) throws Exception {
        if(i < cantidadInicial || i > cantidadDeJugadores())
            throw new CantidadDeJugadoresError("No puedes tener una cantidad de jugadores menor a" + cantidadInicial + "ni mayor a" + cantidadDeJugadores());
        return jugadores.get(i);
    }

}
