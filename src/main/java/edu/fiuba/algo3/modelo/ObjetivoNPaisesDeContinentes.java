package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ObjetivoNPaisesDeContinentes extends ObjetivoBase {
    private List<Continente> continentesAConquistar;
    private List<IPais> paisesAConquistar;
    private Map<Continente, Integer> continentesConMinimoPaises;

    public ObjetivoNPaisesDeContinentes(List<Continente> continentesObligatorios, 
            Map<Continente, Integer> continentesConMinimoPaises) {
        paisesAConquistar = new ArrayList<>();
        for(Continente continente : continentesObligatorios) 
            paisesAConquistar.addAll(continente.obtenerPaises());

        this.continentesConMinimoPaises = continentesConMinimoPaises;
        this.continentesAConquistar = continentesObligatorios;
    }

    @Override
    Boolean objetivoCompletado() {
        return duenio.obtenerPaises().containsAll(paisesAConquistar)
            && contieneCantidadMinimaPaises();
    }

    private boolean contieneCantidadMinimaPaises() {
        for(Entry<Continente, Integer> continente : continentesConMinimoPaises.entrySet()) {
            List<IPais> paisesDeContinente = new ArrayList<IPais>();
            paisesDeContinente.addAll(duenio.obtenerPaises());
            paisesDeContinente.retainAll(continente.getKey().obtenerPaises());
            if(paisesDeContinente.size() < continente.getValue()) return false;
        }
        return true;
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

        texto.concat("\n y obtener minimo de ejercitos:\n");
        for(Entry<Continente, Integer> continente : continentesConMinimoPaises.entrySet()) {
            texto.concat(continente.getKey().obtenerNombre() 
                + ": " + continente.getValue());
        }
        return texto;
	}
}
