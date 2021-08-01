package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;

public class ObjetivoGeneral extends ObjetivoBase {
    @Override
    Boolean objetivoCompletado() {
        return duenio.cantidadPaises() > 30;
    }

    public void inicializar(IJugador duenio) {
        this.duenio = duenio;
        duenio.agregarObjetivoSuscriptor(this);
    }
}
