package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.*;

public class FaseInicio implements IFase, IFaseInicio {
    private List<String> colores;
    private List<Jugador> jugadores;
    List<Pais> paises;

    Turno turno;
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();

    static int minJugadores = 2;
    static int maxJugadores = 6;
    static int cantidadEjercitos = 8; // la cantidad de ejercitos para cada jugador en la etapa inicial es 8
    static int cantidadInicial = 0;

    public FaseInicio(int cantJugadores) throws Exception {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + minJugadores + "y un máximo de"
                    + maxJugadores + "jugadores.");

        colores = inicializarColores();
        paises = inicializarPaises();
        jugadores = inicializarJugadores(cantJugadores);
        turno = new Turno(jugadores);
    }

    // interfaz de inicio

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    //TODO: eliminar acceso directo a jugador con mocks
    Jugador obtenerJugador(int i) throws Exception {
        if (i < cantidadInicial || i > cantidadDeJugadores())
            throw new CantidadDeJugadoresError("No puedes tener una cantidad de jugadores menor a" + cantidadInicial
                    + "ni mayor a" + cantidadDeJugadores());
        return jugadores.get(i);
    }

    // lógica interna

    private List<Pais> inicializarPaises() {
        return Arrays.asList("Puerto Rico", "Colombia", "Venezuela", "Honduras", "Guayana", "Guatemala").stream()
                .map(n -> new Pais(n)).collect(Collectors.toList());
    }

    // TODO: fetch colores default de un archivo o clase distintos
    private List<String> inicializarColores() {
        return Arrays.asList("Azul", "Rojo", "Amarillo", "Verde", "Rosa", "Negro");
    }

    private List<Jugador> inicializarJugadores(int cantJugadores) throws EjercitosException {
        jugadores = jugadoresDeColores(this.colores.subList(0, cantJugadores));
        asignarPaisesAleatoriamenteAJugadores(jugadores);
        asignarEjercitosAJugadores(jugadores);
        return jugadores;
    }
    
    private Boolean validarCantidad(int cant) {
        return (cant >= minJugadores && cant <= maxJugadores);
    }

    private List<Jugador> jugadoresDeColores(List<String> colores) {
        return jugadores = colores.stream()
            .map(c -> new Jugador(c))
            .collect(Collectors.toList());
    }
    private void asignarPaisesAleatoriamenteAJugadores(List<Jugador> jugadores) {
        Collections.shuffle(paises);
        for (int i = 0; i < paises.size(); i++) {
            Pais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).asignarPais(actual);
        }
    }

    private void asignarEjercitosAJugadores(List<Jugador> jugadores) throws EjercitosException {
        for(Jugador j : jugadores) {
            j.agregarEjercitos(cantidadEjercitos);
        }
    }

    // métodos de fase

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
    
    public FaseInicio asFaseInicio() {
        return this;
    }

    public FaseAtacar asFaseAtacar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseColocar asFaseColocar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }

    @Override
    public FaseReagrupar asFaseReagrupar() throws FaseErroneaException {
        throw new FaseErroneaException(null);
    }


}
