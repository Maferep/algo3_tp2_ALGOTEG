package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.IntStream;

import edu.fiuba.algo3.modelo.Interfaces.ITiroDeDados;

import java.util.stream.Collectors;

public class TiroDeDadosFalso implements ITiroDeDados{
        List<Integer> valores;
        public TiroDeDadosFalso (int cantidadDeDados,int valor) {
            valores = new ArrayList<Integer>();
            for(int i = 0; i < cantidadDeDados; i++) valores.add (valor);
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

        //compara los dados de mayor tamaño de cada TiroDeDados, uno a uno, y devuelve
        // una lista de cual TiroDeDados gano
        public List<ITiroDeDados> batallarConDesventaja(ITiroDeDados rival) {
            //ordenar dados de mayor a menor
            this.ordenarDescendientemente();
            rival.ordenarDescendientemente();

            //obtener tamanio minimo de cada tiro
            int minCantidadDados =  Math.min(this.cantidadDados(), rival.cantidadDados());

            // obtener lista de cada ganador
            return IntStream
                    .range(0, minCantidadDados)
                    .mapToObj(i ->
                            this.obtenerDado(i) > rival.obtenerDado(i)
                                    ? this
                                    : rival
                    ).collect(Collectors.toList());
        }
}
