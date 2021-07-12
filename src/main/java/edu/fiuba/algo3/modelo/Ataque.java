package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class Ataque {
        ITiroDeDados dadosAtacante;
        ITiroDeDados dadosDefensor;
        

        public Ataque(Pais defensor, int cantEjercitos) {
                asignarDados(
                        new TiroDeDados(Math.min(cantEjercitos, 3)),
                        new TiroDeDados(Math.min(defensor.ejercitos, 3))
                );
        }

        public Ataque(Pais defensor, ITiroDeDados dado) {
                asignarDados(dado, dado);
        }

        private void asignarDados(ITiroDeDados dadosAtacante, ITiroDeDados dadosDefensor) {
                this.dadosAtacante = dadosAtacante;
                this.dadosDefensor = dadosDefensor;
        }

        public void atacar(Pais atacante, Pais defensor,int cantEjercitos) {
                dadosAtacante.batallar(dadosDefensor);
                long cantVictorias = dadosAtacante.cantidadVictorias();
                long cantDerrotas = dadosAtacante.cantidadDerrotas();
                
                atacante.quitarEjercitos(cantDerrotas);
                defensor.quitarEjercitos(cantVictorias);
                
                if (cantVictorias >= defensor.ejercitos) {
                        Conquista conquista = new Conquista();
                        conquista.conquistar(atacante.obtenerConquistador(), defensor);
                }
        }
}
