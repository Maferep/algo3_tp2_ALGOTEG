package edu.fiuba.algo3.modelo;

public class Continente {
    String nombre;
    int cantidadPaises;
    int cantidadPaisesEnContinente = 0;

    public Continente() {}
    public Continente(String nombreContinente, int cantidadDePaises){
        nombre = nombreContinente;
        cantidadPaises = cantidadDePaises;
    }
    public void agregarPais() {
        this.sumarPais();
    }
    public void sumarPais() {
        cantidadPaisesEnContinente++;
    }
    public void quitarPais() {
        cantidadPaisesEnContinente--;
    }
    public boolean verificarConquista(Continente continente) {
       return (this.cantidadPaisesEnContinente == continente.cantidadPaises);
    }
}
