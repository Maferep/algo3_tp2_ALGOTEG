package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Juego {
	List<Jugador> jugadores;
	List<Pais> paises = Arrays.asList(
		"Puerto Rico", 
		"Colombia", 
		"Venezuela",
		"Honduras",
		"Guayana",
		"Guatemala")
		.stream()
		.map(n -> new Pais(n))
		.collect(Collectors.toList());
	
	public List<String> obtenerPaises() {
		return this.paises.stream()
			.map(p -> p.obtenerNombre())
			.collect(Collectors.toList());
	}

	// Constructores 
	Juego() {
		jugadores = new ArrayList<Jugador>();
	}

	public Juego(String[] nombresJugadores) throws Exception {
		if ( nombresJugadores.length <= 0 )
			throw new Exception();
		jugadores = Arrays.asList(nombresJugadores)
			.stream()
			.map(n -> new Jugador(n))
			.collect(Collectors.toList());
	}

	// Métodos
	public void agregarJugadores(String... nombres) {
		for(String n : nombres)
			jugadores.add(new Jugador(n));
	}

	public void colocarEjercitos(String jugador, int cantidad, String pais) throws Exception {
		jugadores.stream()
			.filter(j -> j.obtenerNombre() == jugador)
			.findAny().get()
			.asignarEjercitosAPais(cantidad, paisPorNombre(pais));
	}

	public int cantidadEjercitosDe(String nombre) {
		return jugadores.stream()
			.filter(j -> j.obtenerNombre() == nombre)
			.findAny().get()
			.cantidadEjercitos();
	}

	public int cantidadDeJugadores() {
		return jugadores.size();
    }

	public void agregarEjercitosAlJugador(String nombre, int i) throws Exception {
		jugadores.stream()
			.filter(j -> j.obtenerNombre() == nombre)
			.findAny().get()
			.agregarEjercitos(i);
	}

	public void asignarPaisesAleatoriamente() {
		for(int i = 0; i < paises.size(); i++){ //TODO hacer aleatorio
			jugadores
				.get(i % jugadores.size())
				.asignarPais(paises.get(i));
		}
	}

	public void asignarPaisAJugador(String nombreJugador, String pais) {
		jugadores.stream()
			.filter(j -> j.nombre == nombreJugador)
			.findAny().get()
			.asignarPais(paisPorNombre(pais));
	}

	public List<String> paisesDe(String nombre) {
		Jugador jugador = jugadores.stream()
			.filter(j -> j.obtenerNombre() == nombre)
			.findAny().orElseThrow();

		return jugador.obtenerPaises().stream()
			.map(p -> p.obtenerNombre())
			.collect(Collectors.toList());
	}

	public void realizarAtaque(
		String paisAtacante, 
		int cantSoldados, 
		String paisDefensor,
		IAtaque tipoAtaque) 
	throws Exception {
		Pais atacante = paises.stream()
				.filter(j -> j.obtenerNombre() == paisAtacante)
				.findAny().orElseThrow();

		Pais defensor = paises.stream()
				.filter(j -> j.obtenerNombre() == paisDefensor)
				.findAny().orElseThrow();

		atacante.atacar(defensor,cantSoldados,tipoAtaque);
	}

	public void agregarEjercitosAlPais(String pais, int cantidadEjercitos) {
		paisPorNombre(pais).agregarEjercitos(cantidadEjercitos);
	}

	//Auxiliares
	
	private Pais paisPorNombre(String nombre) {
		return paises.stream()
			.filter(p -> p.obtenerNombre() == nombre)
			.findAny().get();
	}
}