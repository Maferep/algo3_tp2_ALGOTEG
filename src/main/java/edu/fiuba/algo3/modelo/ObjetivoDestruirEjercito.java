package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import java.util.NoSuchElementException;

public class ObjetivoDestruirEjercito extends ObjetivoBase {
	IJugador jugadorADestruir;

	// Usa el turno para averiguar si el jugador existe
	public ObjetivoDestruirEjercito(ITurno turnoActual, String color) throws ObjetivoException {
		try {
			jugadorADestruir = turnoActual.jugadorDeColor(color);
		} catch (NoSuchElementException e) {
			throw new ObjetivoException("No hay jugador de ese color");
		}
	}

	@Override
	Boolean objetivoCompletado() {
		return jugadorADestruir.cantidadPaises() == 0;
	}

	// se inicializa al ser asignado a un jugador duenio
	public void inicializar(IJugador duenio) {
		this.duenio = duenio;
		jugadorADestruir.agregarObjetivoSuscriptor(this);
	}

	@Override
	public String toString() {
		return "Destruir ejercitos de " + jugadorADestruir.obtenerColor();
	}
}
