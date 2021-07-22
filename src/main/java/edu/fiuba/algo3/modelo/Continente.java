package edu.fiuba.algo3.modelo;
import java.util.List;

public class Continente {
    private List<Pais> paises;

    public Continente(List<Pais> paises) {
        this.paises = paises;
    }

    public Boolean fueConquistadoPor(Jugador jugador) {
        for (int i = 0; i < this.paises.size(); i++) {
            if (this.paises.get(i).obtenerConquistador().obtenerColor() != jugador.obtenerColor()) {
                return false;
            }
        } return true;
    }

