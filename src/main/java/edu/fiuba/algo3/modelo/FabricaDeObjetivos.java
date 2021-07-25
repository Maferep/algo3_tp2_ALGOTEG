package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FabricaDeObjetivos {

    List<IObjetivo> objetivos = new ArrayList<>();
    //hacer mock de esto
    List <IPais> paisesEnAmerica = Arrays.asList(new Pais("Nueva York"),new Pais("Oregon"),new Pais("Mexico"));
    List <IPais> paisesEnEuropa = Arrays.asList(new Pais("Rusia"),new Pais("Francia"));
    List <IPais> paisesEnAsia = Arrays.asList(new Pais("China"),new Pais("India"));

    List<Continente> continentesUno = Arrays.asList(new Continente(paisesEnEuropa));
    List<Continente> continentesDos = Arrays.asList(new Continente(paisesEnAmerica));
    List<Continente> continentesTres = Arrays.asList(new Continente(paisesEnAsia));

    //raro como se agregan los objetivos. repensar
    public FabricaDeObjetivos(ITurno turno) {
        agregarObjetivo(new ObjetivoGeneral());
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentesUno,paisesEnAmerica));
        agregarObjetivo(new ObjetivoDestruirEjercito("Azul", turno));
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentesDos,paisesEnEuropa));
        agregarObjetivo(new ObjetivoDestruirEjercito("Rojo", turno));
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentesTres,paisesEnAsia));
    }

    public void agregarObjetivo(IObjetivo objetivo) {
        objetivos.add(objetivo);
    }

    public List<IObjetivo> objetivos() {
        return objetivos;
    }
}
