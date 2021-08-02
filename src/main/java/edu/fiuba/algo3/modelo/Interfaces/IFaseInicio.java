package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.ObjetivoManager;
import edu.fiuba.algo3.modelo.excepciones.*;

//extraer interfaz para tests
public interface IFaseInicio extends IFase{
    public int cantidadDeJugadores() throws FaseErroneaException;
    public void ubicarEjercitosEnPais(int cantEjercitos, IPais pais) 
        throws FichasInsuficientesException, PaisNoExistenteException, EjercitosException, FaseErroneaException;
    public Mazo obtenerCanje();
    public IMapa obtenerMapa();
    public ITurno obtenerTurno();
	public ObjetivoManager obtenerObjetivos();
}
