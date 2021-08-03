package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FabricaDeObjetivos {

    List<IObjetivo> objetivos = new ArrayList<>();
    IMapa mapa;
    ITurno turno;
    LectorObjetivos lectorObjetivos = new LectorObjetivos();
    public IOrdenador ordenador = new OrdenadorAleatorio();
    public FabricaDeObjetivos(ITurno turno, IMapa mapa) {
        this.turno = turno;
        this.mapa = mapa;
        crearObjetivosMinimoPaises();
        for(String color : turno.obtenerColores())
            agregarObjetivoDeEjercitos(color);
        
        ordenador.ordenar(objetivos);
    }

    public List<IObjetivo> crearObjetivos() {
        return objetivos;
    }

    private void agregarObjetivo(IObjetivo objetivo) {
        objetivos.add(objetivo);
    }

    //TODO: usar objetos para abstraerse de tipo de dato
    private void crearObjetivosMinimoPaises() {
        List<Map<String,Integer>> nombresContinentesYMinimos 
            = lectorObjetivos.obtenerListasDeContinentesYSusMinimos();

        

        for(Map<String,Integer> objetivo : nombresContinentesYMinimos){
            List<Continente> continentesObligatorios = new ArrayList<>();
            Map<Continente, Integer> continenteYMinimo = new HashMap<>();

            for(Entry<String, Integer> continente : objetivo.entrySet()) {
                //buscar continente por nombre
                Continente objetoContinente = mapa.buscarContinente(continente.getKey());
                int minimo = continente.getValue();
                //minimo negativo indica continente obligatorio
                if(continente.getValue() <= 0)
                    continentesObligatorios
                        .add(objetoContinente);
                else continenteYMinimo.put(objetoContinente, minimo);
            }

            agregarObjetivo(
                new ObjetivoNPaisesDeContinentes(
                    continentesObligatorios, continenteYMinimo));
        }

        
    }

    private void agregarObjetivoDeEjercitos(String color){
        try {
            agregarObjetivo(new ObjetivoDestruirEjercito(turno, color));
        } catch (ObjetivoException e) {
            agregarObjetivo(new ObjetivoGeneral());
        }
    }
}
