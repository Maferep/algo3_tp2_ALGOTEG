package edu.fiuba.algo3.modelo.Interfaces;

import java.beans.PropertyChangeListener;

public interface IObjetivo extends PropertyChangeListener{
    void inicializar(IJugador duenio);
}
