package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Interfaces.IOrdenador;

import java.util.Collections;
import java.util.List;

public class OrdenadorAleatorio implements IOrdenador {
    public void ordenar(List<?> lista) {
        Collections.shuffle(lista);
    }
}
