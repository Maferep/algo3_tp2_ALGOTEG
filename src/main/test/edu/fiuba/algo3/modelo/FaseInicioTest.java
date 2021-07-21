package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.factories.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.fases.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

public class FaseInicioTest {
    List<Pais> paises = Arrays.asList(
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

        //TODO test ejemplo
    @Test
    public void test03QueUsaMocks() throws Exception {
        ITurno unJugador = new TurnoMockEjemplo(paises);
        ITurno jugadoresPorPaises = new TurnoMockUnJugadorCadaPais(paises);
        new FaseInicio(unJugador);
    }

    // 1. crear constructor fase inicio que acepte ITurno
    // 2. crear un turno mock que le pases lo que necesitas de la maner
    //mas simple posible
    //3. magia
}
