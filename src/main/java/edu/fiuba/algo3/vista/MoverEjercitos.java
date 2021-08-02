package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.FaseErroneaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;

public class MoverEjercitos implements IVista {

    //TODO URGENTE transferencia de ejercitos hardcodeada
    public MoverEjercitos(Juego juego, ContenedorJuego contenedorJuego, IPais pais, IPais adyacente, Button botonVolver) {
        try {
            juego.transferirEjercitos(3, pais, adyacente);
        } catch (FaseErroneaException | TransferirEjercitosException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void visualizar() {
		// TODO Auto-generated method stub
		
	}

}
