package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContinenteTest {
    public List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "México",
            "Groenlandia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    @Test
    public void test00JugadorConqusitaContinente() {
        Jugador jugador = new Jugador("Azul");
        Continente continente = new Continente(paises);

        paises.forEach(pais -> pais.asignarConquistador(jugador));

        assertTrue(continente.fueConquistadoPor(jugador));
    }

    @Test
    public void test01JugadorNoConquistaContinente() {
        Jugador jugadorRojo = new Jugador("Rojo");
        Jugador jugadorAzul = new Jugador("Azul");

        Continente continente = new Continente(paises);

        paises.forEach(pais -> pais.asignarConquistador(jugadorRojo));

        assertFalse(continente.fueConquistadoPor(jugadorAzul));
    }

}
