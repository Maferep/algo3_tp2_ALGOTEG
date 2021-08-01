package edu.fiuba.algo3.modelo.Mocks;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;

public class PaisMock implements IPais {
    private String nombre;
    private IJugador conquistador;
    
    public PaisMock(String nombre) {
        this.nombre = nombre;
        conquistador = new Jugador("Victor el Victorioso");
        conquistador.asignarPais(this);
    }

    // Este pais SIEMPRE GANA un ataque.
    @Override
    public void atacar(IPais defensor, int cantidadDeSoldados) throws Exception {
        conquistar(defensor);
    }

    @Override
    public void agregarEjercitos(int i) {

    }

    @Override
    public IJugador obtenerConquistador() {
        return conquistador;
    }

    @Override
    public void atacar(IAtaque ataqueFalso) {

    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }

    @Override
    public void agregarAdyacente(IPais iPais) {

    }

    @Override
    public void quitarEjercitos(long cantDerrotas) {

    }

    @Override
    public void conquistar(IPais defensor) {
        (defensor.obtenerConquistador()).quitarPais(defensor);
        defensor.definirConquistador(conquistador);

    }

    @Override
    public int cantidadEjercitos() {
        return 0;
    }

    @Override
    public void definirConquistador(IJugador conquistador) {
        conquistador.asignarPais(this);
        this.conquistador = conquistador;
    }

    @Override
    public void transferirEjercitosA(int cantidad, IPais otroPais) throws TransferirEjercitosException {
    }

    @Override
    public Boolean esAdyacenteA(IPais otroPais) {
        return true;
    }

    @Override
    public boolean sonMismoPais(IPais pais) {
        return pais.obtenerNombre().equals(this.obtenerNombre());
    }
    
}
