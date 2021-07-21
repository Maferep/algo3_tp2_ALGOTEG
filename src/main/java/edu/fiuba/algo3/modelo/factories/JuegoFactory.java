package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.fases.*;
import edu.fiuba.algo3.modelo.Interfaces.IFase;


public class JuegoFactory {
  public IFase crearJuegoTEG(int cantJugadores) throws Exception {
    return new FaseInicio(cantJugadores);
  }
}
