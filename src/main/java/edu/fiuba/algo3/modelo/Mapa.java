package edu.fiuba.algo3.modelo;

import java.util.List;

public class Mapa {
    public List<Pais> paises;

    public Mapa() {
        PaisFactory fachada = new PaisFactory();
        paises = fachada.inicializarMapa();
    }

    public List<Pais> obtenerPaises() {
        return paises;
    }

}
