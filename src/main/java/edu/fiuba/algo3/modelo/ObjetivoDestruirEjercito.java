package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;

import edu.fiuba.algo3.modelo.Jugador;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.NoSuchElementException;

public class ObjetivoDestruirEjercito implements IObjetivo{

    ITurno turnoActual;
	IJugador jugadorADestruir;
	
	public ObjetivoDestruirEjercito(ITurno turnoActual, String color) 
			throws ObjetivoException{
		try {
			jugadorADestruir = turnoActual.jugadorDeColor(color);
		} catch(NoSuchElementException e) {
			throw new ObjetivoException(null);
		}
		jugadorADestruir.agregarObjetivoSuscriptor(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
	}
}
