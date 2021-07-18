package edu.fiuba.algo3.modelo.builders;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.IFase;

public class JuegoBuilder {
  public IFase crearJuegoTEG(int cantJugadores) throws Exception {
    return new FaseInicio(cantJugadores);
  }
}
