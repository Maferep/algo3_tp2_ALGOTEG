package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import java.util.*;
import java.util.stream.*;

public class Canje {
    LinkedList<ITarjeta> mazo = new LinkedList<ITarjeta>();
    public Canje(List<IPais> paises) {
        mazo.addAll(
            paises.stream()
                .map(p -> new Tarjeta(p))
                .collect(Collectors.toList())
        );
    }
    public ITarjeta obtenerTarjeta() {
        return mazo.getFirst();
    }

    public void insertarAlFondoDelMazo(ITarjeta tarjeta) {
        mazo.add(tarjeta);
    }

}
