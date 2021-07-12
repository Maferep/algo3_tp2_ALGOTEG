package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.ITiroDeDados;
import java.util.List; 
public class DadoFalso implements ITiroDeDados {
    public DadoFalso(int cantidadVictorias, int cantidadDerrotas) {
	}
	public int cantidadDados() {return 3;}
    public int obtenerDado(int i) {return 3;}
    public void ordenarDescendientemente() {}
    public List<ITiroDeDados> batallarConDesventaja(ITiroDeDados rival) {return null;}
}
