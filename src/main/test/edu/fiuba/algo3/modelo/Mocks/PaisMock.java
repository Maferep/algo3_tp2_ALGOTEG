package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class PaisMock implements IPais {
    private String nombre;
    private IJugador conquistador;

    public PaisMock(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void agregarEjercitos(int i) {
        // TODO Auto-generated method stub

    }

    @Override
    public IJugador obtenerConquistador() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void atacar(IAtaque ataqueFalso) {
        // TODO Auto-generated method stub

    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }

    @Override
    public void agregarAdyacente(IPais iPais) {
        // TODO Auto-generated method stub

    }

    @Override
    public void quitarEjercitos(long cantDerrotas) {
        // TODO Auto-generated method stub

    }

    @Override
    public void asignarConquistador(IJugador iJugador) {
        // TODO Auto-generated method stub

    }

    @Override
    public int cantidadEjercitos() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<IPais> obtenerAdyacentes() {
        // TODO Auto-generated method stub
        return null;
    }

    //Este pais SIEMPRE GANA un ataque.
    @Override
    public void atacar(IPais defensor, int cantidadDeSoldados) throws Exception {
        defensor.asignarConquistador(this.conquistador);
    }
    
}
