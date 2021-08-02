package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class ObjetivoConquistarPaisesYContinentes extends ObjetivoBase {
    List<Continente> continentesAConquistar;
    List<IPais> paisesAConquistar;

    public ObjetivoConquistarPaisesYContinentes(List<Continente> continentes, List<IPais> paises) {
        paisesAConquistar = new ArrayList<>();
        paisesAConquistar.addAll(paises);
        for(Continente continente : continentes) 
            paisesAConquistar.addAll(continente.obtenerPaises());
    }

    @Override
    Boolean objetivoCompletado() {
        return duenio.obtenerPaises().containsAll(paisesAConquistar);
    }

    public void inicializar(IJugador duenio) {
        this.duenio = duenio;
        duenio.agregarObjetivoSuscriptor(this);
    }

    @Override
	public String toString() {
        String texto = "Conquistar paises: \n";
        for(IPais pais : paisesAConquistar)
            texto = texto.concat(pais.obtenerNombre() + "\n");
        return texto;
	}
}
