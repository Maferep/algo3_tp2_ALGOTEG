package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Tarjeta {
    IPais pais;
    Tarjeta(IPais pais) {
        this.pais = pais;
    }
	public IPais obtenerPais() {
		return pais;
	}

}
