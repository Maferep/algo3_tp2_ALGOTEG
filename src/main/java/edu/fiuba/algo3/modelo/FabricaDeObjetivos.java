package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;

import java.util.ArrayList;
import java.util.List;

public class FabricaDeObjetivos {

    List<IObjetivo> objetivos = new ArrayList<>();

    public void agregarObjetivo(IObjetivo objetivo) {
        objetivos.add(objetivo);
    }

    public List<IObjetivo> objetivos() {
        return objetivos;
    }
}
