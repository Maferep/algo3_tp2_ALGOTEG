package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.interfases.IVista;

public class PasajeDeFases {
    IVista vista;
    public PasajeDeFases(IVista vista){
        this.vista = vista;
    }
    public void visualizar() {
        vista.visualizar();
    }
}
