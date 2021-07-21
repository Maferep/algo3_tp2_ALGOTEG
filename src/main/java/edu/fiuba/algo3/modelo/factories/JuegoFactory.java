package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.fases.*;
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;


public class JuegoFactory {
  public IFase crearJuegoTEG(int cantJugadores, IJugador tipoJugador) throws Exception {
    return new FaseInicio(cantJugadores, tipoJugador);
  }
}
