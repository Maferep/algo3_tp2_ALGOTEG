package edu.fiuba.algo3.modelo.Mocks;

import edu.fiuba.algo3.modelo.Interfaces.*;

public class DadosUsadosMock implements IDado {
    int cantidadVictorias;
    int cantidadDerrotas;

    public DadosUsadosMock(int cantidadVictorias, int cantidadDerrotas) {
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
    public void batallar(IDado rival) {}

    @Override
    public int cantidadVictorias() {
        return this.cantidadVictorias;
    }

    @Override
    public int cantidadDerrotas() {
        return this.cantidadDerrotas;
    }
}
