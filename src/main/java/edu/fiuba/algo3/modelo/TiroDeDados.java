package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.IntStream;

import edu.fiuba.algo3.modelo.Interfaces.ITiroDeDados;

import java.util.stream.Collectors;

//Un conjunto de dados es una lista de valores aleatorios.
// Estos dados siempre devuelven 1.
public class TiroDeDados implements ITiroDeDados {
    List<Integer> valores;
    List<ITiroDeDados> resultado;

    public TiroDeDados (int cantidadDeDados) {
        valores = new ArrayList<Integer>();
		for(int i = 0; i < cantidadDeDados; i++) valores.add ((int)((Math.random()*6)+1));
    }

    public TiroDeDados (int cantidadDeDados,int numero) {
        valores = new ArrayList<Integer>();
        for(int i = 0; i < cantidadDeDados; i++) valores.add (numero);
    }

    public int cantidadDados() {
        return this.valores.size();
    }

    public int obtenerDado(int i) {
        return this.valores.get(i);
    }

    public void ordenarDescendientemente() {
        this.valores.sort(Comparator.reverseOrder());
    }

    @Override
    public void batallar(ITiroDeDados rival) {
        //ordenar dados de mayor a menor
        this.ordenarDescendientemente();
        rival.ordenarDescendientemente();

        //obtener tamanio minimo de cada tiro
        int minCantidadDados =  Math.min(this.cantidadDados(), rival.cantidadDados());

        // obtener lista de cada ganador
        resultado = IntStream
            .range(0, minCantidadDados)
            .mapToObj(i -> 
                this.obtenerDado(i) > rival.obtenerDado(i)
                    ? this
                    : rival
            ).collect(Collectors.toList());

    }

    @Override
    public int cantidadVictorias() {
        return (int) resultado
            .stream()
            .filter(ganador -> ganador.equals(this))
            .count();
    }

    @Override
    public int cantidadDerrotas() {
        return (int) resultado
            .stream()
            .filter(ganador -> !ganador.equals(this))
            .count();
    }
}