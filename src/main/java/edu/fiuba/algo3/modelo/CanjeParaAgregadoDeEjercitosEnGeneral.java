package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.Interfaces.ICanje;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExistenteError;

import java.util.ArrayList;
import java.util.List;

public class CanjeParaAgregadoDeEjercitosEnGeneral implements ICanje {

    //Asimismo, si un jugador posee tres tarjetas de país con el mismo símbolo o
    //tres símbolos distintos puede solicitar un canje según la siguiente tabla:

    List<IPais> paises = new ArrayList <IPais>();
    Simbolo simbolo;
    Boolean encontroTarjeta = false;

    CanjeParaAgregadoDeEjercitosEnGeneral(List <IPais> paises, Simbolo simbolo) {
        this.paises = paises;
        this.simbolo = simbolo;
    }

    public Simbolo obtenerSimbolo() {
        return simbolo;
    }
    public IPais obtenerPais() {
        return paises.get(0);
    }

    public void activarTarjeta(IJugador jugador) throws NoExisteTarjetaException, PaisNoExistenteError {
        for(int i = 0 ; i < jugador.obtenerPaises().size() ; i++) {
            if(!jugador.verificarQueExistaPais(paises.get(i))) {
                throw new PaisNoExistenteError("No tienes ese pais para agregar fichas");
            }
        }
    }
}
