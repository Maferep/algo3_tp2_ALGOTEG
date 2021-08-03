package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.AlgoTegException;
import edu.fiuba.algo3.vista.eventos.*;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VisualizadorFaseReagrupar implements IVista, IVistaFases {

    private Juego juego;
    private ContenedorJuego contenedorJuego;
    VBox contenedor;

    public VisualizadorFaseReagrupar(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        this.contenedor = new VBox();
    }

    @Override
    public void visualizar() {
        contenedorJuego.limpiarAreaMapa();
        contenedorJuego.obtenerBotonera().getChildren().clear();

        Button botonMoverEjercitos = new Button("Transferir Ejercitos");
        Button botonVerTarjetas = new Button("Ver Tarjetas");
        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(new EventoVista(this));

        EventoVista moverEjercitos = new EventoVista(
                new VistaMoverEjercitos(juego, contenedorJuego, botonVolver, this));
        EventoVista verTarjetas = new EventoVista(new VistaTarjetas(juego, contenedorJuego));

        botonMoverEjercitos.setOnAction(moverEjercitos);
        botonVerTarjetas.setOnAction(verTarjetas);

        Button siguiente = new Button("Siguiente");
        siguiente.setOnAction(new BotonMostrarJugadorActual(juego, contenedorJuego, this));

        VBox contenedor = new VBox(imprimirJugador(juego), botonMoverEjercitos, botonVerTarjetas, siguiente);

        contenedorJuego.definirBotonera(contenedor);

    }

    @Override
    public void visualizarJuegoTerminado() throws AlgoTegException {
        contenedorJuego.limpiarBotonera();
        contenedorJuego.limpiarAreaMapa();
        mostrarGanador();
        contenedorJuego.definirSobreMapa(contenedor);
    }

    private void mostrarGanador() throws AlgoTegException {
        Label texto = new Label();
        texto.setText("GANASTE!!! \n" +
                "Jugador" +juego.obtenerGanador().obtenerColor() + "eres el ganador!");
        contenedor.getChildren().add(texto);
        Button opcionSalir = new Button("Finalizar Partida");
        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);
    }

    private Label imprimirJugador(Juego juego) {
        return new NombreJugador(juego.jugadorActual().obtenerColor());
    }

    public void visualizarNuevaFase() {
        try {
            juego.siguienteFase();
        } catch (AlgoTegException e) {
            System.exit(-1);
        }
        PasajeDeFases haciaFaseColocar = new PasajeDeFases(
            new VisualizadorFaseColocar(juego, contenedorJuego));
        haciaFaseColocar.visualizar();
    }

}
