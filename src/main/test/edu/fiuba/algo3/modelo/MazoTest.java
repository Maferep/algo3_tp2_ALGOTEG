package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;
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
        Mazo mazo = new Mazo(paises);
        IPais eeuu = paises.stream()
            .filter(p -> p.obtenerNombre() == "Estados Unidos")
            .findAny()
            .get();
        assertEquals(eeuu, mazo.obtenerTarjeta().obtenerPais());
    }

    //Pruebas para 1er tipo de activacion
    @Test
    public void test02SeActivanTarjetas() throws NoExisteTarjetaException, PaisNoExistenteError {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));
        Pais pais = new Pais("Estados Unidos");
        Simbolo simbolo = new Simbolo("Barco");
        jugador.asignarPais(pais);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnUnPais();

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);
        jugador.activarTarjeta(tarjeta, tipoDeCanje);
    }

    @Test
    public void test03NoSePuedeActivarLaTarjetaDeUnPaisQueNoSeConquisto() throws NoExisteTarjetaException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));
        Pais pais = new Pais("Estados Unidos");

        Simbolo simbolo = new Simbolo("Barco");

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnUnPais();

        assertThrows(PaisNoExistenteError.class, () -> {
            jugador.activarTarjeta(tarjeta, tipoDeCanje);
        });
    }

    @Test
    public void test04NoSePuedeActivarUnaTarjetaQueNoSeTiene() throws NoExisteTarjetaException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));
        Pais pais = new Pais("Estados Unidos");
        Pais otroPais = new Pais("Reino Unido");

        Simbolo simbolo = new Simbolo("Barco");

        jugador.asignarPais(pais);

        Tarjeta tarjeta = new Tarjeta(otroPais, simbolo);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnUnPais();

        assertThrows(NoExisteTarjetaException.class, () -> {
            jugador.activarTarjeta(tarjeta, tipoDeCanje);
        });
    }

    @Test
    public void test05NoSePuedeActivarUnaTarjetaDosVeces() throws NoExisteTarjetaException, PaisNoExistenteError {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));
        Pais pais = new Pais("Estados Unidos");
        jugador.asignarPais(pais);

        Simbolo simbolo = new Simbolo("Barco");

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnUnPais();

        jugador.activarTarjeta(tarjeta, tipoDeCanje);

        assertThrows(NoExisteTarjetaException.class, () -> {
            jugador.activarTarjeta(tarjeta, tipoDeCanje);
        });
    }

    //Pruebas para 2do tipo de activacion

}