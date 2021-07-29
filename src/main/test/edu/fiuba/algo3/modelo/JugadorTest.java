package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {

    @Test
    public void test01JugadorActivaUnaTarjetaPais() throws NoSePuedeProducirCanjeException {
        Jugador jugadorRojo = new Jugador("Rojo");
        IPais argentina = new Pais("Argentina");
        Simbolo simbolo = new Simbolo("Globlo");

        Tarjeta tarjeta = new Tarjeta(argentina, simbolo);

        jugadorRojo.asignarPais(argentina);
        jugadorRojo.agregarTarjetaAleatoria(tarjeta);
        jugadorRojo.activarTarjeta(tarjeta);

        Assert.assertEquals(2, argentina.cantidadEjercitos());
    }

    @Test
    public void test02JugadorNoPuedeActivarTarjetaPais() {
        Jugador jugadorRojo = new Jugador("Rojo");
        IPais argentina = new Pais("Argentina");
        Simbolo simbolo = new Simbolo("Globlo");

        Tarjeta tarjeta = new Tarjeta(argentina, simbolo);

        jugadorRojo.agregarTarjetaAleatoria(tarjeta);

        assertThrows(NoSePuedeProducirCanjeException.class, () -> {
           jugadorRojo.activarTarjeta(tarjeta);
        });
    }
}
