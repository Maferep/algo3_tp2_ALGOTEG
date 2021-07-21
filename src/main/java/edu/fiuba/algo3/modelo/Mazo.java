package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

public class Mazo {
    LinkedList<Tarjeta> tarjetas = new LinkedList<Tarjeta>();
    public Mazo(List<Pais> paises) {
        tarjetas.addAll(
            paises.stream()
                .map(p -> new Tarjeta(p))
                .collect(Collectors.toList())
        );
    }
    public Tarjeta obtenerTarjeta() {
        return tarjetas.getFirst();
    }
}
