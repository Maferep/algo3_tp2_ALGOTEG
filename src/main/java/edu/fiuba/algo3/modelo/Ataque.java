package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Ataque {
        ITiroDeDados dadosAtacante;
        ITiroDeDados dadosDefensor;
        

        public Ataque(Pais defensor, int cantEjercitos) {
                dadosAtacante = new TiroDeDados(Math.min(cantEjercitos, 3));
                dadosDefensor = new TiroDeDados(Math.min(defensor.ejercitos, 3));
        }

        public Ataque(Pais defensor, ITiroDeDados dado) {
                dadosAtacante = dado;
                dadosDefensor = dado;
        }

        public void atacar(Pais atacante, Pais defensor,int cantEjercitos) {
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
                if (cantVictorias >= defensor.ejercitos) {
                        Conquista conquista = new Conquista();
                        conquista.conquistar(atacante.obtenerConquistador(), defensor);
                }
        }
}
