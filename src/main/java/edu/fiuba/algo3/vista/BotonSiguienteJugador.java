package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonMostrarJugadorActual;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.scene.control.Button;

public class BotonSiguienteJugador extends Button {
    public BotonSiguienteJugador(Juego juego, ContenedorJuego contenedorJuego, IVistaFases vista){
        this.setText("Siguiente Jugador");
        BotonMostrarJugadorActual thisJugadorActual 
            = new BotonMostrarJugadorActual(juego, contenedorJuego, vista);
        this.setOnAction(thisJugadorActual);
    }
    
}