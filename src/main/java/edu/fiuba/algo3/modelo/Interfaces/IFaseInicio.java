package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

//extraer interfaz para tests
public interface IFaseInicio {
    public int cantidadDeJugadores();
    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) 
        throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException;
}
