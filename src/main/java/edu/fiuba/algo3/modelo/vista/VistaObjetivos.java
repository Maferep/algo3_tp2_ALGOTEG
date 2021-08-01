package edu.fiuba.algo3.modelo.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaObjetivos {

    VBox contenedorObjetivos;
    private VBox contenedor;

	public VistaObjetivos(Juego juego, VBox contenedor, ContenedorJuego contenedorJuego) {
        this.contenedor = contenedor;
        
        List<String> objetivos = juego.obtenerObjetivos();
        contenedorObjetivos = new VBox();
        for(int i = 0; i < objetivos.size(); i++){
            Label label = new Label();
            label.setText(objetivos.get(i));
            contenedorObjetivos.getChildren().add(label);
        }
    }
    
    public void visualizar(){
        contenedor.getChildren().add(contenedorObjetivos);
    }

}
