package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import java.util.List;

public class Tarjetas {

    public static int cantidadNecesaria = 3;

    private LinkedList<Simbolo> simbolos;

    public Tarjetas(List<Tarjeta> tarjetas) {
        simbolos = new LinkedList<Simbolo>();
        for (Tarjeta tarjeta : tarjetas) {
            simbolos.add(tarjeta.obtenerSimbolo());
        }
    }

    public boolean sonValidas() {
        return (simbolos.size() == cantidadNecesaria) & (sonIguales() | sonDistintos());
    }

    private Boolean sonIguales() {
        Simbolo primerSimbolo = simbolos.getFirst();
        return simbolos
                .stream()
                .allMatch
                        (simbolo -> simbolo.esIgualA(primerSimbolo));
    }

    protected Boolean sonDistintos() {
        LinkedList<Simbolo> listaAuxiliar = (LinkedList<Simbolo>) simbolos.clone();
        for (Simbolo simbolo : simbolos) {
            listaAuxiliar.remove(simbolo);
            if ( listaAuxiliar.stream().anyMatch(simboloTarjeta -> simboloTarjeta.esIgualA(simbolo)) ) { return false; }
            listaAuxiliar.add(simbolo);
        }
        return true;
    }

}
