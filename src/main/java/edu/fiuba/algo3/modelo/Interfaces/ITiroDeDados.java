package edu.fiuba.algo3.modelo.Interfaces;

public interface ITiroDeDados {
    public int cantidadDados();
    public int obtenerDado(int i);
    public void ordenarDescendientemente();
    public void batallar(ITiroDeDados rival);
    public int cantidadVictorias();
    public int cantidadDerrotas();
}