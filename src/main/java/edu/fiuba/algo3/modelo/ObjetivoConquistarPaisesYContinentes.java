package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import java.util.List;

public class ObjetivoConquistarPaisesYContinentes extends ObjetivoBase {
    IJugador duenio;
    List<Continente> continentesAConquistar;
    List<IPais> paisesAConquistar;

    public ObjetivoConquistarPaisesYContinentes(List<Continente> continentes, List<IPais> paises) {
        continentesAConquistar = continentes;
        // TODO: continentes no es estado, sino que en el constructor se agregan los
        // paises continentes
        paisesAConquistar = paises;
    }

    @Override
    Boolean objetivoCompletado() {
        return duenio.obtenerPaises().containsAll(paisesAConquistar);
    }

    public void inicializar(IJugador duenio) {
        this.duenio = duenio;
        duenio.agregarObjetivoSuscriptor(this);
    }
}
