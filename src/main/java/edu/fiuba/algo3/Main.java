package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.ContenedorRealizaJuego;
import edu.fiuba.algo3.modelo.vista.eventos.BotonParaActivarOpcionDePantallaCompletaEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
        Label texto = new Label();
        texto.setText("Ingrese cantidad de jugadores");

        TextField campo = new TextField();
        campo.setPromptText("Ingrese el cantidad de jugadores");

        Button boton = new Button();
        boton.setText("Empezar juego");

        VBox contenedor = new VBox(tablero, texto, campo, boton);

        StackPane ruta = new StackPane();

        ruta.getChildren().addAll(contenedor);

        BotonComenzarJuego botonEnviarEventHandler = new BotonComenzarJuego(campo, texto);
        boton.setOnAction(botonEnviarEventHandler);

        Scene escena = new Scene(ruta);*/

        stage.setTitle("ALGOTEG");

        ContenedorRealizaJuego contenedorRealizaJuego = new ContenedorRealizaJuego(stage);
        Scene escenaRealizaJuego = new Scene(contenedorRealizaJuego, 640, 480);

        ContenedorJuego contenedorJuego = new ContenedorJuego(stage, escenaRealizaJuego, contenedorRealizaJuego);
        Scene escenaJuego = new Scene(contenedorJuego, 640, 480);

        BotonParaActivarOpcionDePantallaCompletaEventHandler BotonParaActivarOpcionDePantallaCompletaEventHandler = new BotonParaActivarOpcionDePantallaCompletaEventHandler(stage, contenedorJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(BotonParaActivarOpcionDePantallaCompletaEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,640,480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }
}