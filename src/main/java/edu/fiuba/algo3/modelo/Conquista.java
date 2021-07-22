package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

public class Conquista {
    public Conquista() {}
    public void conquistar(IJugador iJugador, IPais pais) {
        (pais.obtenerConquistador()).quitarPais(pais);
        pais.asignarConquistador(iJugador);
    }
}
