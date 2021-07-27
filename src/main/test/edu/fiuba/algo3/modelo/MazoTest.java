package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;
import org.junit.Test;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;

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
        .map(pais -> new Pais(pais))
        .collect(Collectors.toList());

    @Test
    public void test01MazoDePaises() {
        Mazo mazo = new Mazo(paises);
        IPais eeuu = paises.stream()
            .filter(pais -> pais.obtenerNombre().equals("Estados Unidos"))
            .findAny()
            .get();
        assertEquals(eeuu, mazo.obtenerTarjeta().obtenerPais());
    }

    @Test
    public void test02ProbarTarjeta() {
        IPais austria = new PaisMock("Austria");
        Tarjeta tarjeta = new Tarjeta(austria, null);
        assertEquals(tarjeta.obtenerPais(), austria);
    }

    //Pruebas para 1er tipo de activacion
    @Test
    public void test02SeActivanTarjetas() throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
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
    public void test03NoSePuedeActivarLaTarjetaDeUnPaisQueNoSeConquistoPrimerTipoDeCanje() throws NoExisteTarjetaException {
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
    public void test04NoSePuedeActivarUnaTarjetaQueNoSeTienePrimerTipoDeCanje() throws NoExisteTarjetaException {
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
    public void test05NoSePuedeActivarUnaTarjetaDosVeces() throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
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

    @Test
    public void test06SePuedenCanjearTresTarjetasConSimbolosDistintos() throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));

        Pais pais = new Pais("Estados Unidos");
        Simbolo simbolo = new Simbolo("Barco");

        Pais paisDos = new Pais("Argentina");
        Simbolo simboloDos = new Simbolo("Estrella");

        Pais paisTres = new Pais("Uruguay");
        Simbolo simboloTres = new Simbolo("Velero");

        jugador.asignarPais(pais);
        jugador.asignarPais(paisDos);
        jugador.asignarPais(paisTres);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnGeneral();

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        Tarjeta tarjetaDos = new Tarjeta(paisDos, simboloDos);
        jugador.agregarTarjetaAleatoria(tarjetaDos);

        Tarjeta tarjetaTres = new Tarjeta(paisTres, simboloTres);
        jugador.agregarTarjetaAleatoria(tarjetaTres);

        jugador.activarTarjeta(tarjeta, tipoDeCanje);
        jugador.activarTarjeta(tarjetaDos, tipoDeCanje);
        jugador.activarTarjeta(tarjetaTres, tipoDeCanje);
    }

    @Test
    public void test07SePuedenCanjearTresTarjetasConSimbolosIguales() throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));

        Pais pais = new Pais("Estados Unidos");
        Simbolo simbolo = new Simbolo("Barco");

        Pais paisDos = new Pais("Argentina");
        Simbolo simboloDos = new Simbolo("Barco");

        Pais paisTres = new Pais("Uruguay");
        Simbolo simboloTres = new Simbolo("Barco");

        jugador.asignarPais(pais);
        jugador.asignarPais(paisDos);
        jugador.asignarPais(paisTres);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnGeneral();

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        Tarjeta tarjetaDos = new Tarjeta(paisDos, simboloDos);
        jugador.agregarTarjetaAleatoria(tarjetaDos);

        Tarjeta tarjetaTres = new Tarjeta(paisTres, simboloTres);
        jugador.agregarTarjetaAleatoria(tarjetaTres);

        jugador.activarTarjeta(tarjeta, tipoDeCanje);
        jugador.activarTarjeta(tarjetaDos, tipoDeCanje);
        jugador.activarTarjeta(tarjetaTres, tipoDeCanje);
    }

    @Test
    public void test08NoSePuedenCanjearTresTarjetasConDosSimbolosIgualesYUnoDistinto() throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException, EjercitosException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));

        Pais pais = new Pais("Estados Unidos");
        Simbolo simbolo = new Simbolo("Estrella");

        Pais paisDos = new Pais("Argentina");
        Simbolo simboloDos = new Simbolo("Estrella");

        Pais paisTres = new Pais("Uruguay");
        Simbolo simboloTres = new Simbolo("Velero");

        jugador.asignarPais(pais);
        jugador.asignarPais(paisDos);
        jugador.asignarPais(paisTres);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnGeneral();

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        Tarjeta tarjetaDos = new Tarjeta(paisDos, simboloDos);
        jugador.agregarTarjetaAleatoria(tarjetaDos);

        Tarjeta tarjetaTres = new Tarjeta(paisTres, simboloTres);
        jugador.agregarTarjetaAleatoria(tarjetaTres);

        jugador.activarTarjeta(tarjeta, tipoDeCanje);
        jugador.activarTarjeta(tarjetaDos, tipoDeCanje);

        assertThrows(NoSePuedeProducirCanjeException.class, () -> {
            jugador.activarTarjeta(tarjetaTres, tipoDeCanje);
        });
    }

    @Test
    public void test09NoSePuedeActivarLaTarjetaDeUnPaisQueNoSeConquistoSegundoTipoDeCanje() throws NoExisteTarjetaException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));
        Pais pais = new Pais("Estados Unidos");

        Simbolo simbolo = new Simbolo("Barco");

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnGeneral();

        assertThrows(PaisNoExistenteError.class, () -> {
            jugador.activarTarjeta(tarjeta, tipoDeCanje);
        });
    }

    @Test
    public void test10NoSePuedeActivarLaTarjetaDeUnPaisQueNoSeConquistoSegundoTipoDeCanje() throws NoExisteTarjetaException {
        Jugador jugador = new Jugador("Rosa");
        jugador.asignarCanje(new Mazo(paises));
        Pais pais = new Pais("Estados Unidos");

        Simbolo simbolo = new Simbolo("Barco");

        Tarjeta tarjeta = new Tarjeta(pais, simbolo);
        jugador.agregarTarjetaAleatoria(tarjeta);

        ICanje tipoDeCanje = new CanjeParaAgregadoDeEjercitosEnGeneral();

        assertThrows(PaisNoExistenteError.class, () -> {
            jugador.activarTarjeta(tarjeta, tipoDeCanje);
        });
    }
}