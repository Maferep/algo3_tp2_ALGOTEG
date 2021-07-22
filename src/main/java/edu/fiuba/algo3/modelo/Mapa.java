package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.IPais;

public class Mapa {
    public List<IPais> paises;
    private Continente asia;
    private Continente americaSur;
    private Continente americaNorte;
    private Continente europa;
    private Continente africa;
    private Continente oceania;

    public Mapa() {
        PaisFactory fachada = new PaisFactory();
        paises = fachada.inicializarMapa();
    }

    public List<IPais> obtenerPaises() {
        return paises;
    }

    //TODO
    //public List<Continente> continentesConquistadosPor(Jugador jugador) {}

}
