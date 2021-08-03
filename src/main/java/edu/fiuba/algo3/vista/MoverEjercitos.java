package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.AdyacenciaException;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MoverEjercitos implements IVista {

    ContenedorJuego contenedor;

    //TODO URGENTE transferencia de ejercitos hardcodeada
    public MoverEjercitos(Juego juego, ContenedorJuego contenedorJuego, IPais pais, IPais adyacente, Button botonVolver)
            throws FaseErroneaException, TransferirEjercitosException, AdyacenciaException {
        
        juego.transferirEjercitos(3, pais, adyacente);
        this.contenedor = contenedorJuego;
    }

	@Override
	public void visualizar() {
		contenedor.obtenerBotonera().getChildren().clear();
		
	}

}
