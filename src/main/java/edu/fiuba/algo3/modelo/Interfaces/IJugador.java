package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.List;

public interface IJugador {

	void quitarPais(IPais pais);

	String obtenerColor();

	void asignarPais(IPais pais);

	void inicializarEjercitos(int cantidadEjercitos) throws EjercitosException;

	public void agregarTarjetaAleatoria(Tarjeta tarjeta);

	int cantidadTarjetas();

	void agregarEjercitosAPais(IPais pais, int cantEjercitos) throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException;

	int cantidadPaises();
	
	List<IPais> obtenerPaises();

	void agregarNuevosEjercitos(int i) throws EjercitosException;

	void quitarEjercitos(int cantidadAQuitar) throws EjercitosException;

	int cantidadEjercitosPorColocar();

	void asignarObjetivo(IObjetivo iObjetivo);
	
	public void agregarObjetivoSuscriptor(IObjetivo objetivo);

	void inicializarPais(IPais actual);

	boolean verificarQueExistaPais(IPais iPais) throws PaisNoExistenteError;

	INumeroDeCanje obtenerNumeroDeCanje();

	public void actualizarNumeroDeCanje();

	public List<Tarjeta> obtenerTarjetas();

	public void canjearTarjetas(List<Tarjeta> tarjetasACanjear, IPais pais) throws NoSePuedeProducirCanjeException;

}
