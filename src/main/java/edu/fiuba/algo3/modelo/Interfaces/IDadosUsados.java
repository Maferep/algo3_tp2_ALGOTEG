package edu.fiuba.algo3.modelo.Interfaces;

public interface IDadosUsados {
    public int cantidadDados();
    public int obtenerDado(int i);
    public void ordenarDescendientemente();
    public void batallar(IDadosUsados rival);
    public int cantidadVictorias();
    public int cantidadDerrotas();
}