package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class ObjetivoConquistarPaisesYContinentes implements IObjetivo {

    List<Continente> continentesAConquistar;
    List<IPais> paisesAConquistar;

    public ObjetivoConquistarPaisesYContinentes(List<Continente> continentes,List<IPais> paises) {
        continentesAConquistar = continentes;
        paisesAConquistar = paises;
    }
    public ObjetivoConquistarPaisesYContinentes(){}

    public boolean seCumpleObjetivo(Jugador jugadorActual) {
        return (jugadorActual.conquistaContinentes(continentesAConquistar) && (jugadorActual.conquistaPaises(jugadorActual,paisesAConquistar)));
    }
}
