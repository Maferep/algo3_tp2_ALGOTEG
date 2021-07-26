package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import org.junit.Test;

import edu.fiuba.algo3.modelo.Interfaces.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MazoTest {

    List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá", 
            "Brasil", 
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
        .stream()
        .map(n -> new Pais(n))
        .collect(Collectors.toList());
    @Test
    public void test01MazoDePaises() {
        Canje mazo = new Canje(paises);
        IPais eeuu = paises.stream()
            .filter(p -> p.obtenerNombre() == "Estados Unidos")
            .findAny()
            .get();
        assertEquals(eeuu, mazo.obtenerTarjeta().obtenerPais());
    }

    //Pruebas para 1er tipo de activacion
    @Test
    public void test02SeActivanTarjetas() throws NoExisteTarjetaException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Canje(paises));
        Pais pais = new Pais("Estados Unidos");
        jugador.asignarPais(pais);

        Tarjeta tarjeta = new Tarjeta(pais);
        jugador.agregarTarjetaAleatoria(tarjeta);
        jugador.activarTarjeta(tarjeta);
    }

    @Test
    public void test03NoSePuedeActivarLaTarjetaDeUnPaisQueNoSeConquisto() throws NoExisteTarjetaException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Canje(paises));
        Pais pais = new Pais("Estados Unidos");

        Tarjeta tarjeta = new Tarjeta(pais);
        jugador.agregarTarjetaAleatoria(tarjeta);

        assertThrows(NoExisteTarjetaException.class, () -> {
            jugador.activarTarjeta(tarjeta);
        });
    }

    //Pruebas para 2do tipo de activacion

}