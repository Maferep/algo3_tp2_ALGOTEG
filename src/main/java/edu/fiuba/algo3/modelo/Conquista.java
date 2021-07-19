package edu.fiuba.algo3.modelo;

public class Conquista {
    public Conquista() {}
    public void conquistar(Jugador conquistador, Pais pais) {
        pais.conquistador.continente.quitarPais();
        pais.asignarConquistador(conquistador);
    }
}
