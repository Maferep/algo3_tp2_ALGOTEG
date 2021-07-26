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
        .map(n -> new Pais(n))
        .collect(Collectors.toList());
    @Test
    public void test00AgregarJugadores() throws Exception {
        FaseInicio primeraEtapa = new FaseInicio(3);
        assertEquals(primeraEtapa.cantidadDeJugadores(), 3);
    }

    @Test
    public void test01NoSePuedeComenzarElJuegoConMenosDeDosJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
            new FaseInicio(0);
            new FaseInicio(1);
        }
        );
    }

    @Test
    public void test02NoSePuedeComenzarElJuegoConMasDeSeisJugadores() throws Exception {
        assertThrows(CantidadDeJugadoresError.class, () ->  {
                    new FaseInicio(7);
                }
        );
    }

    @Test
    public void test03QueUsaMocks() throws Exception {
        ITurno unJugador = new TurnoMockUnJugador(paises);
        Mapa mapa = new Mapa();
        mapa.definirPaises(paises);
        FaseInicio inicio = new FaseInicio(new Mapa(), unJugador, new Mazo(paises));
        assertEquals(1, inicio.cantidadDeJugadores());
    }
}
