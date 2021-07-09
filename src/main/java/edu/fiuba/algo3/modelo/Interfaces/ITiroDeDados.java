package edu.fiuba.algo3.modelo.Interfaces;
import java.util.List;

public interface ITiroDeDados {
    public int cantidadDados();
    public int obtenerDado(int i);
    public void ordenarDescendientemente();
    public List<ITiroDeDados> batallarConDesventaja(ITiroDeDados rival);
}