package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;

import java.beans.PropertyChangeEvent;

public class ObjetivoGeneral implements IObjetivo {
    IJugador duenio;
    Boolean completado = false;

    @Override
    public void propertyChange(PropertyChangeEvent evento) {
        if(!evento.getPropertyName().equals("paises")) 
            return;

        if(duenio.cantidadPaises() >= 30)
            completado = true;
    }

    @Override
    public void inicializar(IJugador duenio) {
        this.duenio = duenio;
        duenio.agregarObjetivoSuscriptor(this);

    }

    @Override
    public Boolean fueCompletado() {
        return completado;
    }

}
