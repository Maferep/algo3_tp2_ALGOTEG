package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

public class Conquista {
    public Conquista() {}
    public void conquistar(IJugador conquistador, IPais defensor) {
        (defensor.obtenerConquistador()).quitarPais(defensor);
        defensor.definirConquistador(conquistador);
    }
}
