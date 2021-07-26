package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.Mocks.PaisMock;
import edu.fiuba.algo3.modelo.Mocks.TurnoMock;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;
import edu.fiuba.algo3.modelo.fases.FaseAtacar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjetivoTest {
    List<String> colores = Arrays.asList("Azul", "Rojo", "Amarillo", "Verde", "Rosa", "Negro");

    @Test
    public void test01SuscribirseAUnJugadorQuePierdeSusPaises() 
            throws ObjetivoException, EjercitosException {
        ITurno turno = new Turno(colores, 2);
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
        ITurno turno = new Turno(colores, 2);
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

        assertEquals(true, objetivo.completado);
    }
}
