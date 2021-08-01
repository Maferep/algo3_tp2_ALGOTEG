package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjetivoBase implements IObjetivo {
    IJugador duenio;
    Boolean completado = false;
    List<PropertyChangeListener> suscriptores = new ArrayList<>();

    @Override
    public void propertyChange(PropertyChangeEvent evento) {
        if (!objetivoCompletado())
            return;

        completado = true;
        PropertyChangeEvent victoria = new PropertyChangeEvent(this, "victoria", null, null);
        for(PropertyChangeListener suscriptor : suscriptores) 
            suscriptor.propertyChange(victoria);
    }

    abstract Boolean objetivoCompletado();

    @Override
    public Boolean fueCompletado() {
        return completado;
    }

    @Override
    public void agregarSuscriptor(PropertyChangeListener suscriptor) {
        suscriptores.add(suscriptor);
    }

}
