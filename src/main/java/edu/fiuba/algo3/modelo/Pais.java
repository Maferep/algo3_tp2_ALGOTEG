package edu.fiuba.algo3.modelo;


public class Pais {
    String nombre;
    int ejercitos;
    Jugador conquistador;

	public Pais(String n) {
		this.nombre = n;
		this.ejercitos = 0;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public int cantidadEjercitos() {
		return ejercitos;
	}

	public void agregarEjercitos(int cantidadEjercitos) {
        ejercitos += cantidadEjercitos;
	}

	public Boolean atacar(Pais defensor, int cantEjercitos) {
		//tirar dados
		TiroDeDados dadosAtacante = new TiroDeDados(Math.min(cantEjercitos, 3));
		TiroDeDados dadosDefensor = new TiroDeDados(Math.min(defensor.ejercitos, 3));
		//calcular victorias de nuestros dados
		long cantVictorias = dadosAtacante
			.batallarConDesventaja(dadosDefensor)
			.stream()
			.filter(
				ganador -> ganador == dadosAtacante
			).count();
		//es victorioso si derrota tantos dados 
		//como ejercitos tiene el pais defensor
		return cantVictorias >= defensor.ejercitos;
	}

	public void asignarConquistador(Jugador conquistador) { this.conquistador = conquistador; }

	public Jugador obtenerConquistador() { return this.conquistador; }

}