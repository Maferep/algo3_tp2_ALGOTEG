package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FabricaDeObjetivos {

    List<IObjetivo> objetivos = new ArrayList<>();
    List <IPais> paises = Arrays.asList(new Pais("EEUU"));
    List <IPais> paisesEnEuropa = Arrays.asList(new Pais("Inglaterra"),new Pais("Francia"));
    List<Continente> continentes = Arrays.asList(new Continente(paisesEnEuropa));

    public FabricaDeObjetivos(ITurno turno) {
        agregarObjetivo(new ObjetivoGeneral());
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentes,paises));
        agregarObjetivo(new ObjetivoDestruirEjercito("Verde", turno));
    }

    public void agregarObjetivo(IObjetivo objetivo) {
        objetivos.add(objetivo);
    }

    public List<IObjetivo> objetivos() {
        return objetivos;
    }
}
