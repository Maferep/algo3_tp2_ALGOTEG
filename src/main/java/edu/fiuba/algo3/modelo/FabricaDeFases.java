package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.fases.*;

public class FabricaDeFases {

	public IFase crearFaseInicio(int cantidadDeJugadores) throws Exception {
		return new FaseInicio(cantidadDeJugadores);
    }
    
    public IFase crearFaseAtacar(ITurno turno, IMapa mapa) throws Exception {
		return new FaseAtacar(turno, mapa);
	}

}
