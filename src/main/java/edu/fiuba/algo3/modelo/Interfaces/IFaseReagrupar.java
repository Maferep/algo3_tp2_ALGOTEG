package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;

//extraer interfaz para tests
public interface IFaseReagrupar {
    public void transferirEjercitos(int cantidad, IPais unPais, IPais otroPais) 
        throws FaseErroneaException;
}
