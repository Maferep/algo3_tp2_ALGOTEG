package edu.fiuba.algo3;

import java.io.IOException;

import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.eventos.BotonParaActivarOpcionDePantallaCompletaEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("ALGOTEG");

        double volumen = 0.2;
       // MediaPlayer musica = agregarMusica(volumen);

        ContenedorJuego contenedorJuego = new ContenedorJuego(stage);
        Scene escenaJuego = new Scene(contenedorJuego, 640, 480);

        BotonParaActivarOpcionDePantallaCompletaEventHandler BotonParaActivarOpcionDePantallaCompletaEventHandler = new BotonParaActivarOpcionDePantallaCompletaEventHandler(stage, contenedorJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(BotonParaActivarOpcionDePantallaCompletaEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,640,480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }

   /*private MediaPlayer agregarMusica(double volumen){
        Media mp3MusicFile = new Media(new File("Kashoot/resources/mipan.mp3").toURI().toString());

        MediaPlayer musica = new MediaPlayer(mp3MusicFile);
        musica.setAutoPlay(true);
        musica.setOnEndOfMedia(() -> musica.seek(Duration.ZERO));
        musica.setVolume(volumen);
        musica.play();

        return musica;
    }*/
}