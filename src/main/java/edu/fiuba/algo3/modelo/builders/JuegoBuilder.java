package edu.fiuba.algo3.modelo.builders;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.Interfaces.IJuegoBuilder;

public class JuegoBuilder implements IJuegoBuilder {

  @Override
  public IFase crearJuegoTEG(int cantJugadores) throws Exception {
    return new FaseInicio(cantJugadores);
  }
}
