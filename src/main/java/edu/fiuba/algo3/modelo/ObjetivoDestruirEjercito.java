package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;

import java.beans.PropertyChangeEvent;
import java.util.NoSuchElementException;

public class ObjetivoDestruirEjercito implements IObjetivo{
	IJugador jugadorDuenio;
	IJugador jugadorADestruir;
	//SOLO PARA TEST reemplazar con mensaje al duenio
	public Boolean completado = false;
	
	//Usa el turno para averiguar si el jugador existe
	public ObjetivoDestruirEjercito(ITurno turnoActual, String color) 
			throws ObjetivoException{
		try {
			jugadorADestruir = turnoActual.jugadorDeColor(color);
		} catch(NoSuchElementException e) {
			throw new ObjetivoException(null);
		}
	}

	//se inicializa al ser asignado a un jugador duenio
	public void inicializar(IJugador duenio) {
		this.jugadorDuenio = duenio;
		jugadorADestruir.agregarObjetivoSuscriptor(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evento) {
		Integer cero = Integer.valueOf(0);
		if(  evento.getPropertyName().equals("cantidadPaises")
			&& evento.getNewValue().equals(cero)) {
            completado = true;
        }
	}
}
