package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import java.util.*;
import java.util.stream.*;

public class Mazo {

    LinkedList<ICanje> mazo = new LinkedList<ICanje>();
    public Mazo(List<IPais> paises) {
        mazo.addAll(
            paises.stream()
                .map(p -> new CanjeParaAgregadoDeEjercitosEnUnPais(p))
                .collect(Collectors.toList())
        );
    }
    public ICanje obtenerTarjeta() {
        return mazo.getFirst();
    }

    public void insertarAlFondoDelMazo(ICanje tarjeta) {
        mazo.add(tarjeta);
    }

}
