package edu.fiuba.algo3.modelo;

import java.util.List;

public class Mapa {
    public List<Pais> paises;

    public Mapa() {
        PaisFactoryTest fachada = new PaisFactoryTest();
        paises = fachada.inicializarMapa();
    }

    public List<Pais> obtenerPaises() {
        return paises;
    }

}
