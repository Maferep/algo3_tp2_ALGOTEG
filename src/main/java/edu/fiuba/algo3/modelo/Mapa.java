package edu.fiuba.algo3.modelo;

import java.util.List;

public class Mapa {
    public List<Pais> paises;
    private Continente asia;
    private Continente americaSur;
    private Continente americaNorte;
    private Continente europa;
    private Continente africa;
    private Continente oceania;

    public Mapa() {
        MapaFachada fachada = new MapaFachada();
        paises = fachada.inicializarMapa();
    }

    public List<Pais> obtenerPaises() {
        return paises;
    }

    //TODO
    //public List<Continente> continentesConquistadosPor(Jugador jugador) {}

}
