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
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());

    List<IPais> paisesAsia = Arrays.asList(
            "China",
            "Japón",
            "Tailandia")
            .stream()
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());

    @Test
    public void test00Reagrupar() throws EjercitosException, TransferirEjercitosException {
        
        FaseReagrupar reagrupar = new FaseReagruparSinConquista(
            new TurnoMockUnJugador(paises), 
            new Mapa(), 
            new Canje(paises));
        IPais paisRojo = new Pais("Rojo");
        IPais paisAzul = new Pais("Azul");
        paisRojo.agregarAdyacente(paisAzul);
        paisAzul.agregarAdyacente(paisRojo);

        int cantidadEjercitos = 3;
        int cantidadEjercitosATransferir = 2;

        paisRojo.agregarEjercitos(cantidadEjercitos);
        reagrupar.transferirEjercitos(cantidadEjercitosATransferir, paisRojo, paisAzul);
    }

    @Test
    public void test01SiNoSonAdyacentesNoTransfiere() 
            throws EjercitosException, TransferirEjercitosException {
        FaseReagrupar reagrupar = new FaseReagruparSinConquista(
            new TurnoMockUnJugador(paises), 
            new Mapa(), 
            new Canje(paises));

        IPais paisRojo = new Pais("Rojo");
        IPais paisAzul = new Pais("Azul");

        int cantidadEjercitos = 4;

        paisRojo.agregarEjercitos(cantidadEjercitos);

        int cantidadEjercitosInvalida = 3;

        assertThrows(TransferirEjercitosException.class, 
            () -> reagrupar.transferirEjercitos(cantidadEjercitosInvalida, paisRojo, paisAzul));
    }

    @Test
    public void test02SiNoTieneEjercitosParaTransferirNoTransfiere() 
            throws EjercitosException, TransferirEjercitosException {
        FaseReagrupar reagrupar = new FaseReagruparSinConquista(
            new TurnoMockUnJugador(paises), 
            new Mapa(), 
            new Canje(paises));

        IPais paisRojo = new Pais("Rojo");
        IPais paisAzul = new Pais("Azul");

        int cantidadEjercitos = 3;

        paisRojo.agregarEjercitos(cantidadEjercitos);

        int cantidadEjercitosInvalida = 3;

        assertThrows(TransferirEjercitosException.class, 
            () -> reagrupar.transferirEjercitos(cantidadEjercitosInvalida, paisRojo, paisAzul));
    }
}

