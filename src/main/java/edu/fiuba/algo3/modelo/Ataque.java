package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.FichasInsuficientesError;

public class Ataque implements IAtaque{
        IDadosUsados dadosAtacante;
        IDadosUsados dadosDefensor;

        IPais atacante;
        IPais defensor;

        static int maxDados = 3;

        public Ataque(IPais atacante, IPais defensor, int cantEjercitos) throws Exception {
                this.atacante = atacante;
                this.defensor = defensor;

                if(atacante.ejercitos <= cantEjercitos 
                || cantEjercitos > maxDados)
                        throw new FichasInsuficientesError("El jugador sólo puede atacar con" + (atacante.ejercitos - 1) + "ejércitos.");

                asignarDados(
                        new DadosUsados(cantEjercitos),
                        new DadosUsados(Math.min(defensor.ejercitos, maxDados))
                );
        }

        public Ataque(IPais atacante, IPais defensor, IDadosUsados dado) throws Exception{
                this.atacante = atacante;
                this.defensor = defensor;

                asignarDados(dado, dado);
        }

        private void asignarDados(IDadosUsados dadosAtacante, IDadosUsados dadosDefensor) throws Exception {
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
