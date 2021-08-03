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
    private Juego juego;
    private ContenedorJuego contenedorJuego;
    private VBox contenedor;
    private IPais atacante;
    private IPais defensor;

    private int ejercitosInicialesAtacante;
    private int ejercitosInicialesDefensor;
    private String conquistadorInicialDefensor;
    private Button ataqueBtn = new Button();

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
        conquistadorInicialDefensor = defensor.obtenerConquistador().obtenerColor();
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

        ataqueBtn.setText("Realizar ataque");

        BotonRealizarAtaqueEventHandler ataqueEvento = new BotonRealizarAtaqueEventHandler(juego, atacante, defensor, atacanteCampo, this);
        ataqueBtn.setOnAction(ataqueEvento);

        contenedor.getChildren().addAll(atacanteCampo, defensorCampo, ataqueBtn);
    }

    public void mostrarResultado() {
        Label atacanteEjercitos = new Label();
        int ejercitosActualesAtacante = ejercitosInicialesAtacante - atacante.cantidadEjercitos();
        atacanteEjercitos.setText(atacante.obtenerConquistador().obtenerColor() + " perdió " + ejercitosActualesAtacante + ".");

        Label defensorEjercitos = new Label();
        int ejercitosActualesDefensor = ejercitosInicialesDefensor - defensor.cantidadEjercitos();
        defensorEjercitos.setText(conquistadorInicialDefensor + " perdió " + ejercitosActualesDefensor + ".");

        Label conquista = new Label();

        if (defensor.cantidadEjercitos() == 0) { conquista.setText(atacante.obtenerConquistador().obtenerColor() + " conquistó " + defensor.obtenerNombre() + "."); }

        contenedor.getChildren().addAll(atacanteEjercitos, defensorEjercitos, conquista);
        contenedorJuego.definirBotonera(contenedor);
    }

    public void mostrarAdvertencia() {
        int cantidadPosible = 3;
        if ( ejercitosInicialesAtacante < 3 ) { cantidadPosible = ejercitosInicialesAtacante - 1; }

        Label mensaje = new Label();
        mensaje.setText("¡Ojo! La cantidad de ejércitos ingresada no es válida. Sólo podes atacar con " + cantidadPosible + " ejércitos.");

        contenedor.getChildren().add(mensaje);
        contenedorJuego.definirBotonera(contenedor);
    }

    public void deshabilitarBotonDeAtaque() {
        ataqueBtn.setDisable(true);
    }

    private void agregarBotonSiguienteJugador() {

    }
}
