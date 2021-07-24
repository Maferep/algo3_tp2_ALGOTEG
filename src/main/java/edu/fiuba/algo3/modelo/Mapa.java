package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.List;

public class Mapa implements IMapa {
    private List<IPais> paises;

    @Override
    public void definirPaises(List<IPais> paises) {
        this.paises = paises;

    }

    @Override
    public List<IPais> obtenerPaises() {
        return paises;
    }
}

