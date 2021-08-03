package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonAtaqueEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonRealizarAtaqueEventHandler;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VisualizadorAtaque implements IVista {
    Juego juego;
    ContenedorJuego contenedorJuego;
    VBox contenedor;
    IPais atacante;
    IPais defensor;

    int ejercitosInicialesAtacante;
    int ejercitosInicialesDefensor;

    public VisualizadorAtaque(Juego juego, IPais atacante, IPais defensor, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.atacante = atacante;
        this.defensor = defensor;
        this.contenedorJuego = contenedorJuego;
        contenedor = new VBox();
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        ejercitosInicialesAtacante = atacante.cantidadEjercitos();
        ejercitosInicialesDefensor = defensor.cantidadEjercitos();
    }

    @Override
    public void visualizar() {
        escribirTitulo();
        realizarAtaque();

        contenedorJuego.definirBotonera(contenedor);
    }

    private void escribirTitulo() {
        Label titulo = new Label();
        titulo.setText("Elijan los ejércitos con los que quieren atacar.");

        contenedor.getChildren().add(titulo);
    }

    private void realizarAtaque() {
        TextField atacanteCampo = new TextField();
        atacanteCampo.setPromptText("Ejércitos de atacante");

        TextField defensorCampo = new TextField();
        defensorCampo.setPromptText("Ejércitos de defensor: " + defensor.cantidadEjercitos());
        defensorCampo.setDisable(true);

        Button ataqueBtn = new Button();
        ataqueBtn.setText("Realizar ataque");

        contenedor.getChildren().addAll(atacanteCampo, defensorCampo, ataqueBtn);

        BotonRealizarAtaqueEventHandler ataqueEvento = new BotonRealizarAtaqueEventHandler(juego, atacante, defensor, atacanteCampo, this);
        ataqueBtn.setOnAction(ataqueEvento);

    }

    public void mostrarResultado() {
        Label atacanteEjercitos = new Label();
        int ejercitosActualesAtacante = ejercitosInicialesAtacante - atacante.cantidadEjercitos();
        atacanteEjercitos.setText(atacante.obtenerConquistador().obtenerColor() + " perdió " + ejercitosActualesAtacante + ".");

        Label defensorEjercitos = new Label();
        int ejercitosActualesDefensor = ejercitosInicialesDefensor - defensor.cantidadEjercitos();
        defensorEjercitos.setText(defensor.obtenerConquistador().obtenerColor() + " perdió " + ejercitosActualesDefensor + ".");

        Label conquista = new Label();

        if (defensor.cantidadEjercitos() == 0) { conquista.setText(atacante.obtenerConquistador().obtenerColor() + " conquistó " + defensor.obtenerNombre() + "."); }

        contenedor.getChildren().addAll(atacanteEjercitos, defensorEjercitos);
        contenedorJuego.definirBotonera(contenedor);
    }
}
