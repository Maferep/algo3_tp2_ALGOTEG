package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ObjetivoConquistarPaisesYContinentes;
import edu.fiuba.algo3.modelo.Interfaces.ObjetivoGeneral;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetivoTest {
        /*
    ObjetivoConquistarPaisesYContinentes objetivoConquistarPaisesYContinentes = new ObjetivoConquistarPaisesYContinentes();
    ObjetivoGeneral objetivoGeneral = new ObjetivoGeneral();
    ObjetivoDestruirEjercito objetivoDestruirEjercito = new ObjetivoDestruirEjercito(turno);*/

    @Test
    public void test00SeAsignanObjetivosAJugadores() throws Exception {
        List <IPais> paises = Arrays.asList(new Pais("EEUU"));
        List <IPais> paisesEnEuropa = Arrays.asList(new Pais("Inglaterra"),new Pais("Francia"));
        List<Continente> continentes = Arrays.asList(new Continente(paisesEnEuropa));
        Objetivo objetivo = new Objetivo();

        objetivo.agregarObjetivo(new ObjetivoGeneral());
        objetivo.agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentes,paises));

        assertEquals(objetivo.objetivos.size(), 2);
        Juego juegoNuevo = new Juego(2, objetivo.objetivos);
        assertEquals(juegoNuevo.faseActual.obtenerObjetivo().objetivos.size(), 2);
    }
}
