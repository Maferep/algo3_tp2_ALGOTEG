package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaMoverEjercitos {

	private VBox contenedor;
    private Juego juego;
    private ContenedorJuego contenedorJuego;

    public VistaMoverEjercitos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.contenedor = contenedor;
    }

	public void visualizar() {
        IJugador jugadorActual = juego.jugadorActual();
        Object Button;
		for(IPais pais : jugadorActual.obtenerPaises()){
            Button paisJugador = new Button(pais.obtenerNombre());
            
            EventoMostrarAdyacentes eventoAdyacentes 
                = new EventoMostrarAdyacentes(juego, contenedor, contenedorJuego, pais);
            contenedor.getChildren().add(paisJugador);
        }
        contenedor.getChildren().add()
	}
    
}
