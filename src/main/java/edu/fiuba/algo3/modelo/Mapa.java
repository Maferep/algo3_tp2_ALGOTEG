package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.IPais;

public class Mapa {
    public List<IPais> paises;

    public Mapa() {
        PaisFactory fachada = new PaisFactory();
        paises = fachada.inicializarMapa();
    }

    public List<IPais> obtenerPaises() {
        return paises;
    }

}
