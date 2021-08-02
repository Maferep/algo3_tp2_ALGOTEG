package edu.fiuba.algo3.modelo.Interfaces;

public interface IDado {
    public int cantidadDados();
    public int obtenerDado(int i);
    public void ordenarDescendientemente();
    public void batallar(IDado rival);
    public int cantidadVictorias();
    public int cantidadDerrotas();
}