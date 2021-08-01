package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
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
        stage.setTitle("ALGOTEG");

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
}