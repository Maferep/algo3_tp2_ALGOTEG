package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nombre;
    private List<IPais> paises;

    public Continente(String nombre, List<IPais> paises) {
        this.nombre = nombre;
        this.paises = paises;
    }

    public void agregarPais(IPais pais) {
        paises.add(pais);
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

