package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IObjetivo;
import edu.fiuba.algo3.modelo.Interfaces.IPais;

import java.util.List;

public class ObjetivoConquistarPaisesYContinentes implements IObjetivo {

    List<Continente> continentesAConquistar;
    List<IPais> paisesAConquistar;

    public ObjetivoConquistarPaisesYContinentes(List<Continente> continentes,List<IPais> paises) {
        continentesAConquistar = continentes;
        paisesAConquistar = paises;
    }

    public boolean seCumpleObjetivo(Jugador jugadorActual) {
        return (jugadorActual.conquistaContinentes(continentesAConquistar) && (jugadorActual.conquistaPaises(paisesAConquistar)));
    }
}
