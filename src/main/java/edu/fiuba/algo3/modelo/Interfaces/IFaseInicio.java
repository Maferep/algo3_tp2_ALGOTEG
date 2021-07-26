package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Canje;
import edu.fiuba.algo3.modelo.ObjetivoManager;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.List;

//extraer interfaz para tests
public interface IFaseInicio {
    public int cantidadDeJugadores() throws FaseErroneaException;
    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) 
        throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException, FaseErroneaException;
    public Canje obtenerCanje();
    public IMapa obtenerMapa();
    public ITurno obtenerTurno();
}
