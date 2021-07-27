package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.excepciones.*;

//extraer interfaz para tests
public interface IFaseInicio {
    public int cantidadDeJugadores() throws FaseErroneaException;
    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) 
        throws FichasInsuficientesError, PaisNoExistenteError, EjercitosException, FaseErroneaException;
    public Mazo obtenerCanje();
    public IMapa obtenerMapa();
    public ITurno obtenerTurno();
}
