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
    IOrdenador ordenador = new OrdenadorAleatorio();

    public Mazo(IMapa mapa) {
        MazoFachada mazoFachada = new MazoFachada(mapa);
        mazo = mazoFachada.obtenerTarjetas();
        ordenador.ordenar(mazo);
    }
    public Tarjeta obtenerTarjeta() {
        return mazo.remove();
    }

    public void insertarAlFondoDelMazo(Tarjeta tarjeta) {
        mazo.add(tarjeta);
    }

}
