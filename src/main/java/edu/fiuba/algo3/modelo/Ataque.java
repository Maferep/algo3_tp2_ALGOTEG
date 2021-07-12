package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Ataque {
        ITiroDeDados dadosAtacante;
        ITiroDeDados dadosDefensor;

        //TODO: deprecate
        public Ataque(Pais defensor, int cantEjercitos, int numeroAtacante, int numeroDefensor) {
                dadosAtacante = new TiroDeDados(Math.min(cantEjercitos, 3),numeroAtacante);
                dadosDefensor = new TiroDeDados(Math.min(defensor.ejercitos, 3),numeroDefensor);
        }
        public Ataque(Pais defensor, int cantEjercitos) {
                dadosAtacante = new TiroDeDados(Math.min(cantEjercitos, 3));
                dadosDefensor = new TiroDeDados(Math.min(defensor.ejercitos, 3));
        }

        public Ataque(Pais defensor, ITiroDeDados dadoFalso) {
                dadosAtacante = dadoFalso;
                dadosDefensor = dadoFalso;
        }

        public Boolean atacar(Pais atacante, Pais defensor,int cantEjercitos) {
                if(cantEjercitos >= atacante.cantidadEjercitos()) { return false;}

                dadosAtacante.batallar(dadosDefensor);

                //calcular victorias de nuestros dados
                long cantVictorias = dadosAtacante.cantidadVictorias();
                //calcular derrotas de nuestros dados
                long cantDerrotas = dadosAtacante.cantidadDerrotas();
                //cuento la cantidad de derrotas para poder saber cuantos soldados quitar.
                atacante.quitarEjercitos(cantDerrotas);
                defensor.quitarEjercitos(cantVictorias);
                //es victorioso si derrota tantos dados
                //como ejercitos tiene el pais defensor
                return cantVictorias >= defensor.ejercitos; // aca se deberia llamar a la clase Conquista para ver si conquistó o no, creo.
        }
}
