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
        for (int i = 0; i < this.paises.size(); i++) {
            if (!this.paises.get(i).obtenerConquistador().obtenerColor().equals(jugador.obtenerColor())) {
                return false;
            }
        }
        return true;
    }

}

