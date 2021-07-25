package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetivoTest {
    @Test
    public void test00SeAsignanObjetivosAJugadores() throws Exception {
        List <IPais> paises = Arrays.asList(new Pais("EEUU"));
        List <IPais> paisesEnEuropa = Arrays.asList(new Pais("Inglaterra"),new Pais("Francia"));
        List<Continente> continentes = Arrays.asList(new Continente(paisesEnEuropa));
        FabricaDeObjetivos objetivo = new FabricaDeObjetivos();
        objetivo.agregarObjetivo(new ObjetivoGeneral());
        objetivo.agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentes,paises));
        //objetivo.agregarObjetivo(new ObjetivoDestruirEjercito("Verde"));

        assertEquals(objetivo.objetivos.size(), 2);
        Juego juegoNuevo = new Juego(2, objetivo);
        assertEquals(juegoNuevo.faseActual.obtenerObjetivo().objetivos.size(), 2);
    }
}
