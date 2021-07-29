package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;

import java.util.List;
/*
    Utilizado por el Jugador para mantener el estado de sus canjes y
    realizar canjes. Persiste a lo largo de la vida del Jugador.
*/
public class Canje {
    INumeroDeCanje numero;

    public Canje() {
        numero = new PrimerCanje();
    }

    /*
        Recibe el mazo del juego, un jugador y una lista de tarjetas.
        Le asigna al jugador nuevos ejercitos por colocar.
    */
    public int realizarCanje(List<Tarjeta> listaTarjetas, Mazo mazo)
            throws NoSePuedeProducirCanjeException, EjercitosException {
        Tarjetas tarjetas = new Tarjetas(listaTarjetas);
        if (!tarjetas.sonValidas()) 
            throw new NoSePuedeProducirCanjeException(
                "No es posible realizar el canje con estas tarjetas."); 

        //agregar ejercitos
        int cantidadEjercitos = numero.cantidadDeSoldadosParaCanjear();

        //insertar al fondo del mazo
        for(Tarjeta tarjeta : listaTarjetas)
            mazo.insertarAlFondoDelMazo(tarjeta);

        //actualizar numero de canje
        numero.actualizar();

        return cantidadEjercitos;
    }
}