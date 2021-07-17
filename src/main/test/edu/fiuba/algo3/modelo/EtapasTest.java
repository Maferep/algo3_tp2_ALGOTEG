package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.builders.*;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EtapasTest {
    IJuegoBuilder juegoBuilder = new JuegoBuilder();

    @Test
    public void test00AgregarJugadores() throws Exception {
        juegoBuilder.crearJuegoTEG(3);
    }

    @Test
    public void test01agregarEjercitos() throws Exception {
        // internamente, asigna paises y objetivos a 4 colores
        IFase fase = juegoBuilder.crearJuegoTEG(4);
        fase.realizar();
        assertTrue(fase.faseCompletada());
    }

    @Test
    public void test02PasarPorEtapasDistintas() throws Exception {
        //genera una etapa de inicio en estado 'finalizado' de ejemplo
        IFase fase = juegoBuilder.crearJuegoTEG(4);
        while(!fase.esFinDeJuego()) {
            //realizar() contiene toda la lógica e interacción de usuario
            fase.realizar();
            assertTrue(fase.faseCompletada());
            fase = fase.siguienteFase();
        }
        
    }
}