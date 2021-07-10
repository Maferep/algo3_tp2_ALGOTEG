package edu.fiuba.algo3.modelo;

public class AtaqueFalso {

    public long calcularCantidadVictorias(TiroDeDadosFalso dadosAtacante, TiroDeDadosFalso dadosDefensor) {
        return dadosAtacante
                .batallarConDesventaja(dadosDefensor)
                .stream()
                .filter(
                        ganador -> ganador == dadosAtacante
                ).count();
    }

    public long calcularCantidadDerrotas(TiroDeDadosFalso dadosAtacante, TiroDeDadosFalso dadosDefensor) {
        return dadosAtacante
                .batallarConDesventaja(dadosDefensor)
                .stream()
                .filter(
                        ganador -> ganador == dadosDefensor
                ).count();
    }

    public Boolean atacar(Pais atacante, Pais defensor, int cantEjercitos, int numeroParaDado) {
        //tirar dados
        TiroDeDadosFalso dadosAtacante = new TiroDeDadosFalso(Math.min(cantEjercitos, 3-1),numeroParaDado); // siempre es la cantidad de ejercitos menos 1
        TiroDeDadosFalso dadosDefensor = new TiroDeDadosFalso(Math.min(defensor.ejercitos, 3),numeroParaDado);
        //calcular victorias de nuestros dados
        long cantVictorias = calcularCantidadVictorias(dadosAtacante, dadosDefensor);
        //calcular derrotas de nuestros dados
        long cantDerrotas = calcularCantidadDerrotas(dadosAtacante, dadosDefensor);
        //cuento la cantidad de derrotas para poder saber cuantos soldados quitar.
        atacante.quitarEjercitos(cantDerrotas);
        defensor.quitarEjercitos(cantVictorias);
        //es victorioso si derrota tantos dados
        //como ejercitos tiene el pais defensor
        return cantVictorias >= defensor.ejercitos; // aca se deberia llamar a la clase Conquista para ver si conquistó o no, creo.
    }
}
