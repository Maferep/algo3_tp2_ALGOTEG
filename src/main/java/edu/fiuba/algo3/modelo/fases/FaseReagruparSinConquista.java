package edu.fiuba.algo3.modelo.fases;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteException;

import java.util.List;

public class FaseReagruparSinConquista extends FaseReagrupar {

    public FaseReagruparSinConquista(ITurno turno, IMapa paises, Mazo mazo) {
        super(turno, paises, mazo);
    }

    public IFase faseActual() {
        return this;
    }

    @Override
    public void activarTarjeta(Tarjeta tarjeta) throws NoSePuedeProducirCanjeException, NoExisteTarjetaException, PaisNoExistenteException {

    }

    @Override
    public void realizarCanje(List<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException, EjercitosException {

    }
}
