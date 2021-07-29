package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.INumeroDeCanje;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;

import java.util.List;

public class Canje {
    private Tarjetas tarjetas;
    public Canje(List<Tarjeta> tarjetasElegidas) {
        tarjetas = new Tarjetas(tarjetasElegidas);
    }

    public void realizarCanje(IPais pais, INumeroDeCanje nroCanje) throws NoSePuedeProducirCanjeException {
        if (!tarjetas.sonValidas()) { throw new NoSePuedeProducirCanjeException("No es posible realizar el canje con estas tarjetas."); }
        int cantidadEjercitos = nroCanje.cantidadDeSoldadosParaCanjear();
        pais.agregarEjercitos(cantidadEjercitos);
    }
}