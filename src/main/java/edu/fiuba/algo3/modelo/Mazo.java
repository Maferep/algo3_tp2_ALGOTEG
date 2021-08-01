package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import java.util.*;
import java.util.stream.*;

/*
    El mazo debe persistir a lo largo del juego, por lo tanto es responsabilidad
    del usuario recibirlo y pasarlo como parámetro para realizar operaciones
    que lo involucran.
*/
public class Mazo {
    LinkedList<Tarjeta> mazo = new LinkedList<Tarjeta>();
    public Mazo(List<IPais> paises) {
        mazo.addAll(
            paises.stream()
                .map(p -> new Tarjeta(p,null))
                .collect(Collectors.toList())
        );
    }
    public Tarjeta obtenerTarjeta() {
        return mazo.remove();
    }

    public void insertarAlFondoDelMazo(Tarjeta tarjeta) {
        mazo.add(tarjeta);
    }

}
