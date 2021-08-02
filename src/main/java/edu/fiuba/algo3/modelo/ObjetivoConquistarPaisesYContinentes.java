package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ObjetivoConquistarPaisesYContinentes implements IObjetivo {
    IJugador duenio;
    List<Continente> continentesAConquistar;
    List<IPais> paisesAConquistar;
    // TODO TEMP PARA TEST
    private Boolean completado = false;

    public ObjetivoConquistarPaisesYContinentes(List<Continente> continentes, List<IPais> paises) {
        continentesAConquistar = continentes;
        // TODO: continentes no es estado, sino que en el constructor se agregan los
        // paises continentes
        paisesAConquistar = paises;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evento) {
        if (!evento.getPropertyName().equals("paises"))
            return;

        // todo: encapsular con método "tiene paises"
        List<IPais> paises = duenio.obtenerPaises();

        if (paises.containsAll(paisesAConquistar))
            // TODO sistema para enviar mensaje al duenio
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

    @Override
    public void agregarSuscriptor(PropertyChangeListener suscriptor) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        String objetivo = "Conquistar paises:\n";
        for(IPais pais : paisesAConquistar)
            objetivo.concat(pais.obtenerNombre()).concat("\n");
        
        return objetivo;
    }
}
