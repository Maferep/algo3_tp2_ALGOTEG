package edu.fiuba.algo3.modelo;

public class Ataque {
        TiroDeDados dadosAtacante;
        TiroDeDados dadosDefensor;
        public Ataque(Pais defensor, int cantEjercitos, int numeroAtacante, int numeroDefensor) {
                dadosAtacante = new TiroDeDados(Math.min(cantEjercitos, 3),numeroAtacante);
                dadosDefensor = new TiroDeDados(Math.min(defensor.ejercitos, 3),numeroDefensor);
        }
        public Ataque(Pais defensor, int cantEjercitos) {
                dadosAtacante = new TiroDeDados(Math.min(cantEjercitos, 3));
                dadosDefensor = new TiroDeDados(Math.min(defensor.ejercitos, 3));
        }

public long calcularCantidadVictorias(TiroDeDados dadosAtacante, TiroDeDados dadosDefensor) {
        return dadosAtacante
        .batallarConDesventaja(dadosDefensor)
        .stream()
        .filter(
        ganador -> ganador == dadosAtacante
        ).count();
}

public long calcularCantidadDerrotas(TiroDeDados dadosAtacante, TiroDeDados dadosDefensor) {
        return dadosAtacante
        .batallarConDesventaja(dadosDefensor)
        .stream()
        .filter(
        ganador -> ganador == dadosDefensor
        ).count();
}

public Boolean atacar(Pais atacante, Pais defensor,int cantEjercitos) { //paso x param el constructor
        //tirar excepcion en caso de que la cant de ejercitos sea mayor a la cant de soldados que se tiene
        /*if(cantEjercitos >= atacante.cantidadEjercitos()) {
                throw new RuntimeException("La cantidad de ejercitos requeridos en la batalla debe ser menor a la que el atacante tiene originalmente.");
        } */// aca iria la excepcion. Como la testeo?
        if(cantEjercitos >= atacante.cantidadEjercitos()) {
          return false;
        }
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
