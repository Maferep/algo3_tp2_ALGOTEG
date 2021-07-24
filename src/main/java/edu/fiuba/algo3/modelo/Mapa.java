package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;

import java.util.List;

public class Mapa {
    List<Continente> continentes;
    List<IPais> paises;

    public Mapa() {
        MapaFachada mapaFachada = new MapaFachada();
        paises = mapaFachada.obtenerPaises();;
    }

    public void asignarPaises(List<Jugador> jugadores) { }

    //public List<Continente> continentesConquistadosPor(Jugador jugador) { }
}
