package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Tarjeta;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;

import java.util.List;

public interface IFase {

	Boolean faseCompletada();

	IFase faseActual();

	ITurno turno();

	IFase siguienteFase(IFabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException, TurnoException;

	public void siguienteTurno() throws TurnoException, FaseIncompletaException;

	Boolean esFinDeJuego();

	IFaseInicio obtenerFaseInicio() throws FaseErroneaException;

	FaseAtacar obtenerFaseAtacar() throws FaseErroneaException;

	FaseColocar obtenerFaseColocar() throws FaseErroneaException;

	FaseReagrupar obtenerFaseReagrupar() throws FaseErroneaException;

	void activarTarjeta(Tarjeta tarjeta) throws NoSePuedeProducirCanjeException, NoExisteTarjetaException, PaisNoExistenteException;

	void realizarCanje(List<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException, EjercitosException;
}
