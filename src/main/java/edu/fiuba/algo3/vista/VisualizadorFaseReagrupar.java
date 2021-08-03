package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.*;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VisualizadorFaseReagrupar implements IVista, IVistaFases {

    private Juego juego;
    private ContenedorJuego contenedorJuego;
    

	public VisualizadorFaseReagrupar(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }
    
    @Override
    public void visualizar(){
        contenedorJuego.limpiarAreaMapa();
        contenedorJuego.obtenerBotonera().getChildren().clear();
        Button botonMoverEjercitos = new Button("Transferir Ejercitos");
        Button botonVerTarjetas = new Button("Ver Tarjetas");
        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(new EventoVista(this));

        EventoVista moverEjercitos = new EventoVista(
            new VistaMoverEjercitos(juego, contenedorJuego, botonVolver));
        EventoVista verTarjetas = new EventoVista(
            new VistaTarjetas(juego, contenedorJuego));
        
        botonMoverEjercitos.setOnAction(moverEjercitos);
        botonVerTarjetas.setOnAction(verTarjetas);
        
        VBox contenedor = new VBox(botonMoverEjercitos, botonVerTarjetas);

        contenedorJuego.definirBotonera(contenedor);
    }

    public void visualizarNuevaFase() {
        PasajeDeFases haciaFaseColocar = new PasajeDeFases(new VisualizadorFaseColocar(juego, contenedorJuego));
        haciaFaseColocar.visualizar();
    }

}
