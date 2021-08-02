package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaMoverEjercitos implements IVista {

	private VBox contenedor;
    private Juego juego;
    private ContenedorJuego contenedorJuego;

    public VistaMoverEjercitos(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.contenedor = contenedor;
    }

	public void visualizar() {
        
	}

    @Override
    public void visualizar(ContenedorJuego contenedor) {
        IJugador jugadorActual = juego.jugadorActual();
        Object Button;
		for(IPais pais : jugadorActual.obtenerPaises()){
            Button paisJugador = new Button(pais.obtenerNombre());
            
            EventoMostrarAdyacentes eventoAdyacentes 
                = new EventoMostrarAdyacentes(juego, contenedorJuego, pais);
            contenedor.getChildren().add(paisJugador);
        }

    }
    
}
