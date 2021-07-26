package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.IPais;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ObjetivoConquistarPaisesYContinentes implements IObjetivo {
    IJugador duenio;
    List<Continente> continentesAConquistar;
    List<IPais> paisesAConquistar;

    public ObjetivoConquistarPaisesYContinentes(List<Continente> continentes, List<IPais> paises) {
        continentesAConquistar = continentes;
        paisesAConquistar = paises;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evento) {

    }

    @Override
    public void inicializar(IJugador duenio) {
        this.duenio = duenio;
        duenio.agregarObjetivoSuscriptor(this);

    }
}
