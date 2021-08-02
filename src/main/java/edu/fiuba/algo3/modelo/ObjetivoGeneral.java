package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;

public class ObjetivoGeneral extends ObjetivoBase {
    static int CANT_PAISES = 30;
    @Override
    Boolean objetivoCompletado() {
        return duenio.cantidadPaises() >= CANT_PAISES;
    }

    public void inicializar(IJugador duenio) {
        this.duenio = duenio;
        duenio.agregarObjetivoSuscriptor(this);
    }
    @Override
	public String toString() {
		return "Conquistar " + CANT_PAISES + "paises.";
	}
}
