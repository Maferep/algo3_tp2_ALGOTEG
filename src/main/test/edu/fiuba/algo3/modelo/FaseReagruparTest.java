package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.Mocks.*;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fases.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FaseReagruparTest {
    List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "Brasil",
            "Italia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    List<IPais> paisesAsia = Arrays.asList(
            "China",
            "Japón",
            "Tailandia")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());

    //Juego de una ronda con 2 jugadores.
    //En esta ronda no se deben atacar pero sí colocar nuevos ejércitos.
    @Test
    public void test00Reagrupar() throws EjercitosException {
        FaseReagrupar reagrupar = new FaseReagruparSinConquista(
            new TurnoMockUnJugador(paises), 
            new Mapa(), 
            new Canje(paises));
        
        reagrupar.transferirEjercitos(3, new Pais("Rojo"), new Pais("Azul"));
    }
}

