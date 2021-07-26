package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;

import edu.fiuba.algo3.modelo.Jugador;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ObjetivoDestruirEjercito implements IObjetivo{

    String colorDelJugadorADestruir;
    ITurno turnoActual;
	IJugador jugadorADestruir;
	
	public ObjetivoDestruirEjercito(String color) {
        colorDelJugadorADestruir = color;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
