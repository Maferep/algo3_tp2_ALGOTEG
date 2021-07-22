package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.List;

public interface IJugador {

    public Continente continente = new Continente();

	void quitarPais(IPais pais);

	String obtenerColor();

	void asignarPais(IPais pais);

	void agregarEjercitos(int cantidadEjercitos) throws EjercitosException;

	void agregarTarjetaAleatoria(Tarjeta obtenerTarjeta);

	int cantidadTarjetas();

	void verificarCantidadDeEjercitos(int cantEjercitos) throws FichasInsuficientesError;

	void verificarPais(IPais pais) throws PaisNoExistenteError;

	List<IPais> obtenerPaises();

	void agregarNuevosEjercitos(int i) throws EjercitosException;

	int cantidadEjercitos();
}
