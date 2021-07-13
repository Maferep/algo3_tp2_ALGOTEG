package edu.fiuba.algo3.modelo;
import java.util.List;

public interface IAltego {

	public List<String> obtenerPaises();

    public void agregarJugadores(String... nombres);

	public void colocarEjercitos(String jugador, int cantidad, String pais) throws Exception;

	public int cantidadEjercitosDe(String nombre);

	public int cantidadDeJugadores();

	public void agregarEjercitosAlJugador(String nombre, int i) throws Exception;

	public void asignarPaisesAleatoriamente();

	public void asignarPaisAJugador(String nombreJugador, String pais);

	public List<String> paisesDe(String nombre);

	public void agregarEjercitosAlPais(String pais, int cantidadEjercitos);

	public void realizarAtaque(
		String atacante, 
		int numEjercitos, 
		String defensor) throws Exception;

	public Pais paisPorNombre(String nombre);

}
