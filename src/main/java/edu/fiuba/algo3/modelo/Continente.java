package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;

import java.util.List;

public class Continente {
    private List<IPais> paises;

    public Continente(List<IPais> paises) {
        this.paises = paises;
    }

    public Boolean fueConquistadoPor(IJugador jugador) {
        for (IPais pais : paises) {
            if (!pais.obtenerConquistador().esIgualA(jugador)) { return false; }
        }
        return true;
    }

    public List<IPais> paises() {
        return paises;
    }

}

