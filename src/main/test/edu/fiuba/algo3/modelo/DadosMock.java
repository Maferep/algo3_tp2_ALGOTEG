package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.ITiroDeDados;

public class DadosMock implements ITiroDeDados {
    int cantidadVictorias;
    int cantidadDerrotas;

    public DadosMock(int cantidadVictorias, int cantidadDerrotas) {
        this.cantidadVictorias = cantidadVictorias;
        this.cantidadDerrotas = cantidadDerrotas;
	}
	public int cantidadDados() {
        return cantidadVictorias + cantidadDerrotas;
    }

    public int obtenerDado(int i) {
        return 0;
    }
    public void ordenarDescendientemente() {}
    public void batallar(ITiroDeDados rival) {}

    @Override
    public int cantidadVictorias() {
        return this.cantidadVictorias;
    }

    @Override
    public int cantidadDerrotas() {
        return this.cantidadDerrotas;
    }
}
