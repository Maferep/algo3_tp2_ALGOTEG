package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.*;

public class EtapaInicial implements IFase {
    List<Jugador> jugadores;
    List<String> colores;
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();
    
    
    
    static int minimoJugadores = 2;
    static int maximoJugadores = 6;
    static int cantidadEjercitos = 8; // la cantidad de ejercitos para cada jugador en la etapa inicial es 8
    static int cantidadInicial = 0;
    Turno sistemaDeTurnos = new Turno();

    // para que pasen los test hago una lista de paises random
    List<Pais> paises;

    public EtapaInicial(int cantJugadores) throws Exception {
        if(!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError(
                    "El juego tiene un mínimo de" + minimoJugadores 
                    + "y un máximo de"  + maximoJugadores + "jugadores.");
        colores = inicializarColores();
        paises = inicializarPaises();
        jugadores = inicializarJugadores(cantJugadores);
        asignarTurnosAleatoriamente();
    }

    private List<Pais> inicializarPaises() {
        return Arrays.asList(
            "Puerto Rico", 
            "Colombia", 
            "Venezuela", 
            "Honduras", 
            "Guayana", 
            "Guatemala")
        .stream()
        .map(n -> new Pais(n))
        .collect(Collectors.toList());
    }

    // TODO: fetch colores default de un archivo o clase distintos
    private List<String> inicializarColores() {
        return Arrays.asList("Azul", "Rojo", "Amarillo", "Verde", "Rosa", "Negro");
    }

    private Boolean validarCantidad(int cantidad) {
        return (cantidad >= minimoJugadores && cantidad <= maximoJugadores);
    }

    private List<Jugador> inicializarJugadores(int cantJugadores) throws EjercitosException {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < cantJugadores; i++) {
            Jugador jugador = new Jugador(colores.get(i));
            jugadores.add(jugador);
        }
        asignarPaisesAleatoriamenteAJugadores(jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }
            

    private void asignarTurnosAleatoriamente() throws Exception {
        //Turno sistemaDeTurnos = new Turno();
        for(int i = 0 ; i < cantidadDeJugadores() ; i++) {
            obtenerJugador(i).asignarNumeroParaTurno();
        }
        sistemaDeTurnos.determinarTurnos(jugadores);
    }

    public void asignarTurnosNoAleatoriamente(int numero) throws Exception {
        //Turno sistemaDeTurnos = new Turno();
        for(int i = 0 ; i < cantidadDeJugadores() ; i++) {
            obtenerJugador(i).asignarNumeroParaTurnoMock(numero+i);
        }
        sistemaDeTurnos.determinarTurnos(jugadores);
    }

    // se va a tener que leer el archivo de paises e ir cargandose en la lista en la
    // etapa inicial.

    private void asignarPaisesAleatoriamenteAJugadores(List<Jugador> jugadores) {
        for (int i = 0; i < paises.size(); i++) {
            jugadores.get(i % jugadores.size()).asignarPais(paises.get(i));
        }
    }

    @Deprecated
    private void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException {
        for (int i = 0; i < jugadores.size(); i++) {
            (jugadores.get(i)).agregarEjercitos(cantidadEjercitos);
        }
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    Jugador obtenerJugador(int i) throws Exception {
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
    public Boolean esFinDeJuego() {
        // TODO Auto-generated method stub
        return false;
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) {
        // TODO Auto-generated method stub
        //al 'terminar de ubicar' la etapa inicial se considera completada
        estrategia = estrategia.actualizar();
    }

    public EtapaInicial asFaseInicio() {
        return this;
    }

    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        // TODO Auto-generated method stub
        throw new FaseErroneaException(null);
    }

}
