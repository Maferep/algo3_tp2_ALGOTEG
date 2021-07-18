package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.builders.TurnoBuilder;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.*;
import java.util.stream.*;

public class FaseInicio implements IFase, IFaseInicio {
    private List<String> colores;
    private List<Jugador> jugadores;
    List<Pais> paises;

    Turno turno;
    IEstrategiaFase estrategia = new EstrategiaInicioSinCompletar();
    TurnoBuilder builder;

    static int minJugadores = 2;
    static int maxJugadores = 6;

    public FaseInicio(int cantJugadores) throws Exception {
        if (!validarCantidad(cantJugadores))
            throw new CantidadDeJugadoresError("El juego tiene un mínimo de" + minJugadores + "y un máximo de"
                    + maxJugadores + "jugadores.");

        colores = inicializarColores();
        paises = inicializarPaises();
        turno = builder.crearTurno(colores, paises, cantJugadores);
    }

    // interfaz de inicio

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    public void ubicarEjercitosEnPais(int cantEjercitos, Pais pais) {
        // TODO ubicarEjercitos
        //al 'terminar de ubicar' la etapa inicial se considera completada
        estrategia = estrategia.actualizar();
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

    private Boolean validarCantidad(int cant) {
        return (cant >= minJugadores && cant <= maxJugadores);
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
    
    @Override
    public FaseInicio asFaseInicio() {
        return this;
    }

    @Override
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
