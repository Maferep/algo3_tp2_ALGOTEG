package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import java.util.*;
import java.util.stream.*;

public class Canje {
    LinkedList<Tarjeta> mazo = new LinkedList<Tarjeta>();
    public Canje(List<IPais> paises) {
        mazo.addAll(
            paises.stream()
                .map(p -> new Tarjeta(p))
                .collect(Collectors.toList())
        );
    }
    public Tarjeta obtenerTarjeta() {
        return mazo.getFirst();
    }

    public void insertarAlFondoDelMazo(Tarjeta tarjeta) {
        mazo.add(tarjeta);
    }

}
