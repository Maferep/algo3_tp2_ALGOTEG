package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.*;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaReagrupar implements IVista {

    VBox contenedorObjetivos;
    Button botonSiguiente;
    MostrarObjetivoHandler objetivoHandler;
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    

	public VistaReagrupar(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }
    
    @Override
    public void visualizar(){
        
        Button botonMoverEjercitos = new Button("Transferir Ejercitos");
        Button botonVerTarjetas = new Button("Ver Tarjetas");

        //TODO refactor polimorfismo
        EventoVista moverEjercitos = new EventoVista(new VistaMoverEjercitos(juego, contenedorJuego));
        EventoVista verTarjetas = new EventoVista(new VistaTarjetas(juego, contenedorJuego));
        
        botonMoverEjercitos.setOnAction(moverEjercitos);
        botonVerTarjetas.setOnAction(verTarjetas);
        
        VBox contenedor = new VBox(botonMoverEjercitos, botonVerTarjetas);

        contenedorJuego.definirBotonera(contenedor);
    }

    /*
        El evento mostrarObjetivoHandler causa que se llame a este método
    */
    public void mostrarEjercitos () {
        
    }

    public void mostrarTarjetas () {
        
    }

}
