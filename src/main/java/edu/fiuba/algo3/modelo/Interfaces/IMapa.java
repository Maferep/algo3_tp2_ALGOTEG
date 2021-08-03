package edu.fiuba.algo3.modelo.Interfaces;

import java.util.List;

import edu.fiuba.algo3.modelo.Continente;

public interface IMapa {
    public void definirPaises(List<IPais> paises);
    public List<IPais> obtenerPaises();
    public List<String> obtenerNombresDeContinentes();
    public Continente buscarContinente(String nombre);
}
