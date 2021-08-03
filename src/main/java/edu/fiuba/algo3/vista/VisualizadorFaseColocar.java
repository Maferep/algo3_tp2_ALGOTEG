package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.MostrarTarjetasCanjeEventHandler;
import edu.fiuba.algo3.vista.eventos.MostrarTarjetasPaisEventHandler;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class VisualizadorFaseColocar implements IVista, IVistaFases {
    VBox contenedor;
    Juego juego;
    ContenedorJuego contenedorJuego;
    static String ARCHIVO_FONDO = "file:src/main/resources/fondoBlanco.jpeg";
    Map<String, Color> coloresParaJugadores = new HashMap<String,Color>();

    public VisualizadorFaseColocar(Juego juego, ContenedorJuego contenedorJuego) {
        juego.faseActual().turno().actualizarListaDeJugadoresAlCambiarDeFase();
        this.contenedor = new VBox();
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
        cargarColores(this.coloresParaJugadores);

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
    }

    private void cargarColores(Map <String,Color> coloresParaJugadores) {
        coloresParaJugadores.put("Azul",Color.web("#0000FF", 1.0));
        coloresParaJugadores.put("Rojo",Color.web("#DC143C", 1.0));
        coloresParaJugadores.put("Amarillo",Color.web("#FFD700", 1.0));
        coloresParaJugadores.put("Verde",Color.web("#008000", 1.0));
        coloresParaJugadores.put("Rosa",Color.web("#FF69B4", 1.0));
        coloresParaJugadores.put("Negro",Color.web("#000000", 1.0));
    }

    @Override
    public void visualizar() {
        imprimirJugador(juego.jugadorActual());
        mostrarOpciones();

        contenedorJuego.definirBotonera(contenedor);
    }

    @Override
    public void visualizarNuevaFase() {
        new VisualizadorFaseAtacar(juego, contenedorJuego).visualizar();
    }

    private void imprimirJugador(IJugador jugador) {
        javafx.scene.image.Image imagen = new Image(ARCHIVO_FONDO);
        BackgroundImage imagenDeFondo= new BackgroundImage(
                imagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Color color = this.obtenerColorDelJugadorActual(jugador);
        Label nombreJugador = new NombreJugador(
                color,
                new Background(imagenDeFondo),
                "Jugador " + jugador.obtenerColor());

        contenedor.getChildren().add(nombreJugador);
    }

    private Color obtenerColorDelJugadorActual(IJugador jugador) {
        return (this.coloresParaJugadores.get(jugador.obtenerColor()));
    }

    private void mostrarOpciones() {
        Button activarTarjetaOpcion = new Button();
        activarTarjetaOpcion.setText("Activar tarjetas");
        MostrarTarjetasPaisEventHandler tarjetasPais = new MostrarTarjetasPaisEventHandler(juego, contenedorJuego);
        activarTarjetaOpcion.setOnAction(tarjetasPais);

        Button canjearOpcion = new Button();
        canjearOpcion.setText("Canjear tarjetas");
        MostrarTarjetasCanjeEventHandler tarjetasCanje = new MostrarTarjetasCanjeEventHandler(juego, contenedorJuego);
        canjearOpcion.setOnAction(tarjetasCanje);

        Button colocarOpcion = new Button();
        colocarOpcion.setText("Colocar ejércitos");

        contenedorJuego.getChildren().addAll(activarTarjetaOpcion, canjearOpcion, colocarOpcion);
    }
}
