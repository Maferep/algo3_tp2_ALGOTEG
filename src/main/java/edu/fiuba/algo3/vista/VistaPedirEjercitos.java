package edu.fiuba.algo3.vista;

import java.lang.reflect.Field;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.vista.eventos.EventoVista;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaPedirEjercitos implements IVista {

    private Juego juego;
    private ContenedorJuego contenedorJuego;
    private IPais pais;
    private IPais adyacente;
    private Button botonVolver;

    private VBox contenedorBotones;

    public VistaPedirEjercitos(
            Juego juego, 
            ContenedorJuego contenedor, 
            IPais pais, IPais adyacente, Button botonVolver) {

        
        this.juego = juego;
        this.contenedorJuego = contenedor;
        this.pais = pais;
        this.adyacente = adyacente;
        this.botonVolver = botonVolver;
    }

    @Override
    public void visualizar() {
        contenedorJuego.limpiarAreaMapa();
        contenedorJuego.limpiarBotonera();
        Label texto = new Label("Ingrese cantidad de Ejercitos");
        TextField campoEjercitos = new TextField();

        Button botonVolverPedirEjercitos = new Button("Volver");
        EventoVista volver = new EventoVista(this);
        botonVolverPedirEjercitos.setOnAction(volver);

        Button aceptar = new Button("aceptar");
        IVista ejercitos = 
            new VistaVerificarEjercitos(
                juego, contenedorJuego, pais, adyacente, campoEjercitos, botonVolverPedirEjercitos);
        aceptar.setOnAction(new EventoVista(ejercitos));
        contenedorBotones = new VBox(texto, campoEjercitos, aceptar);
        contenedorJuego.definirBotonera(contenedorBotones);
    }

/*     
    } */

}
