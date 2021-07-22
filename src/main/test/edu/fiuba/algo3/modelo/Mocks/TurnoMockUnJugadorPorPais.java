package edu.fiuba.algo3.modelo.Mocks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;

//TODO puedes renombrarlo a lo que quieras que haga el mock.
//Trata que sea lo mas transparente posible lo que hace el mock.
public class TurnoMockUnJugadorPorPais implements ITurno {
    List<IJugador> s;
    int indice = 0;
    public TurnoMockUnJugadorPorPais(List<IPais> paises) throws EjercitosException {
         s = paises.stream()
            .map(p -> inicializar(p))
            .collect(Collectors.toList());
    }
    

    public IJugador inicializar(IPais pais) {
        IJugador j = new Jugador(pais.obtenerNombre() + "Conq");
        j.asignarPais(pais);
        return j;
    }

    public IJugador jugadorActual() {
        return s.get(indice);
    }

    @Override
    public void siguienteJugador() {
        indice = (indice + 1) % s.size();
    }

    @Override
    public int cantidadDeJugadores() {
        return s.size();
    }
    
}