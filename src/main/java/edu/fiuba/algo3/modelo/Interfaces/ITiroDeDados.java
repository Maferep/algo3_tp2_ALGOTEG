package edu.fiuba.algo3.modelo.Interfaces;

public interface ITiroDeDados {
    public int cantidadDados();
    public int obtenerDado(int i);
    public void ordenarDescendientemente();
    public void batallarConDesventaja(ITiroDeDados rival);
    public int cantidadVictorias();
    public int cantidadDerrotas();
}