package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

class Mazo {
    LinkedList<Tarjeta> tarjetas = new LinkedList<Tarjeta>();
    Mazo(List<Pais> paises) {
        tarjetas.addAll(
            paises.stream()
                .map(p -> new Tarjeta(p))
                .collect(Collectors.toList())
        );
    }
    Tarjeta obtenerTarjeta() {
        return tarjetas.getFirst();
    }
}
