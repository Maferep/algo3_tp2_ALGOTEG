package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class PaisMockSiemprePierde implements IPais {
    private String nombre;
    private IJugador conquistador;

    public PaisMockSiemprePierde(String nombre) {
        conquistador = new Jugador("Pedro el Perdedor");
        this.nombre = nombre;
    }

    //Este pais SIEMPRE PIERDE un ataque.
    @Override
    public void atacar(IPais defensor, int cantidadDeSoldados) throws Exception {
        // pierde al no imponer su conquistador al defensor
    }

    @Override
    public void agregarEjercitos(int i) {
        // TODO Auto-generated method stub

    }

    @Override
    public IJugador obtenerConquistador() {
        return conquistador;
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
    public void conquistar(IPais defensor) {
        (defensor.obtenerConquistador()).quitarPais(defensor);
        defensor.definirConquistador(conquistador);
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

    @Override
    public void definirConquistador(IJugador conquistador) {
		conquistador.asignarPais(this);
		this.conquistador = conquistador;
	}

    
    
}
