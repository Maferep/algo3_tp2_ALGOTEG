package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.List;

public interface IJugador {

	void quitarPais(IPais pais);

	String obtenerColor();

	void asignarPais(IPais pais);

	void inicializarEjercitos(int cantidadEjercitos) throws EjercitosException;

	void agregarTarjetaAleatoria(Tarjeta obtenerTarjeta);

	int cantidadTarjetas();

	void agregarEjercitosAPais(IPais pais, int cantEjercitos) throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException;

	List<IPais> obtenerPaises();

	void agregarNuevosEjercitos(int i) throws EjercitosException;

	void quitarEjercitos(int cantidadAQuitar) throws EjercitosException;

	int cantidadEjercitos();

    void asignarObjetivo(IObjetivo iObjetivo);

	boolean esDestruido();

	String colorDeJugador();

	boolean cumplioObjetivo();
}
