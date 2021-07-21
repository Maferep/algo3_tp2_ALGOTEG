package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Interfaces.ITurno;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

//TODO puedes renombrarlo a lo que quieras que haga el mock.
//Trata que sea lo mas transparente posible lo que hace el mock.
public class TurnoMockUnJugadorCadaPais implements ITurno {

    public TurnoMockUnJugadorCadaPais(List<Pais> paises) throws EjercitosException {
    }

    public Jugador jugadorActual() {
        return null;
    }

    @Override
    public void siguienteJugador() {
    }

    @Override
    public int cantidadDeJugadores() {
        return 1;
    }
    
}