package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjetivoTest {
    List<String> colores = Arrays.asList("Azul", "Rojo", "Amarillo", "Verde", "Rosa", "Negro");
    List<IPais> paises = Arrays.asList(
            "Puerto Rico",
            "Colombia",
            "Venezuela",
            "Honduras",
            "Guayana",
            "Guatemala")
            .stream()
            .map(n -> new Pais(n))
            .collect(Collectors.toList());
    @Test
    public void test01SuscribirseAUnJugadorQuePierdeSusPaises() 
            throws ObjetivoException, EjercitosException {
        ITurno turno = new Turno(colores, 2, null);
        //creación de objetivo falla por ser un color inexistente
        assertThrows(
            ObjetivoException.class, 
            () ->
                {
                    ObjetivoDestruirEjercito objetivo 
                        = new ObjetivoDestruirEjercito(turno, "Amarillo");
                }
            );
    }

    @Test
    public void test02CantarVictoria() 
            throws ObjetivoException, EjercitosException {
        ITurno turno = new Turno(colores, 2,null);
        ObjetivoDestruirEjercito objetivo 
                        = new ObjetivoDestruirEjercito(turno, "Rojo"  );
        assertNotEquals(null, objetivo);

        //Los objetivos estan INACTIVOS al estar en el mazo, 
        //ACTIVOS si tienen duenio.
        turno.jugadorActual().asignarObjetivo(objetivo);
        turno.siguienteJugador();

        //quitar paises para "vencer" al jugador lol
        List<IPais> paisesDePerdedor = new ArrayList<IPais>();
        paisesDePerdedor.addAll(turno.jugadorActual().obtenerPaises());
        for(IPais pais : paisesDePerdedor)
            turno.jugadorActual().quitarPais(pais);

        assertEquals(true, objetivo.fueCompletado());
    }
    @Test
    public void test03CantarVictoriaConContinentes() 
            throws ObjetivoException, EjercitosException {
        ITurno turno = new Turno(colores, 2,null);
        ObjetivoConquistarPaisesYContinentes objetivo 
                        = new ObjetivoConquistarPaisesYContinentes(null, paises);
        assertNotEquals(null, objetivo);

        //Asignar el objetivo suscribe al objetivo a los paises de su duenio.
        turno.jugadorActual().asignarObjetivo(objetivo);

        //agregar paises de la lista para "vencer" al jugador
        List<IPais> paisesAConquistar = new ArrayList<IPais>();
        paisesAConquistar.addAll(paises);
        assertTrue(paisesAConquistar.size() > 2);
        //TODO: agregar los paises de los continentes
        for(IPais pais : paisesAConquistar)
            turno.jugadorActual().asignarPais(pais);

        assertEquals(true, objetivo.fueCompletado());
    }
}
