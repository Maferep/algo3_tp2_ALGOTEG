package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;

public class Ataque implements IAtaque{
        ITiroDeDados dadosAtacante;
        ITiroDeDados dadosDefensor;

        Pais atacante;
        Pais defensor;

        static int maxDados = 3;

        public Ataque(Pais atacante, Pais defensor, int cantEjercitos) throws Exception {
                this.atacante = atacante;
                this.defensor = defensor;

                if(atacante.ejercitos <= cantEjercitos 
                || cantEjercitos > maxDados)
                        throw new FichasInsuficientesError("El jugador sólo puede atacar con" + (atacante.ejercitos - 1) + "ejércitos.");

                asignarDados(
                        new TiroDeDados(cantEjercitos),
                        new TiroDeDados(Math.min(defensor.ejercitos, maxDados))
                );
        }

        public Ataque(Pais atacante, Pais defensor, ITiroDeDados dado) throws Exception{
                this.atacante = atacante;
                this.defensor = defensor;

                asignarDados(dado, dado);
        }

        private void asignarDados(ITiroDeDados dadosAtacante, ITiroDeDados dadosDefensor) throws Exception {
                if(dadosAtacante.cantidadDados() > maxDados || dadosAtacante.cantidadDados() > maxDados)
                        throw new Exception("no puedes tirar más de" + maxDados + "dados");
                this.dadosAtacante = dadosAtacante;
                this.dadosDefensor = dadosDefensor;
        }

        public void atacar() {
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
