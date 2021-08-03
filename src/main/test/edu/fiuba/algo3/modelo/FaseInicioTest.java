package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.fases.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

public class FaseInicioTest {
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
    public void test00AgregarJugadores() throws Exception {
        int cantidadJugadores = 3;

        FaseInicio primeraEtapa = new FaseInicio(cantidadJugadores);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01NoSePuedeComenzarElJuegoConMenosDeDosJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresException.class, () ->  {
            new FaseInicio(0);
            new FaseInicio(1);
        }
        );
    }

    @Test
    public void test02NoSePuedeComenzarElJuegoConMasDeSeisJugadores() throws Exception {
        int cantidadJugadoresInvalida = 7;

        assertThrows(CantidadDeJugadoresException.class, () ->  {
                    new FaseInicio(cantidadJugadoresInvalida);
                }
        );
    }

    @Test
    public void test03QueUsaMocks() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paises);
        MapaMock mapa = new MapaMock(paises);
        FaseInicio inicio = new FaseInicio(new Mapa(), unJugador, new Mazo(mapa), null);
        assertEquals(1, inicio.cantidadDeJugadores());
    }
}
