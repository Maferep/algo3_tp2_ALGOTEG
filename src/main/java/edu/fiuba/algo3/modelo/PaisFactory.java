package edu.fiuba.algo3.modelo;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import java.util.*;

public class PaisFactory {
    private List<String> paisesParse;
    private Dictionary<String, List<String>> adyacenciasParse;
    private Dictionary<String, Pais> paisesDic;
    public List<Pais> paises;

    public PaisFactory() {
        LectorPaises lectorPaises = new LectorPaises();
        paisesParse = lectorPaises.obtenerPaises();
        adyacenciasParse = lectorPaises.obtenerAdyacencias();
        paisesDic = new Hashtable<String, Pais>();
        paises = new ArrayList<Pais>();

    }

    public List<Pais> inicializarMapa() {
        this.inicializarPaises();
        this.agregarAdyacencias();
        return paises;
    }

    @Deprecated
    //SUGERENCIA: Esto se comporta como una factory de paises que usa Mapa, 
    //deberiamos testear usando la lista 'paises' que devuelve
    public Pais obtenerPais(String pais) {
        return paisesDic.get(pais);
    }

    private void inicializarPaises() {
        for (int i = 0; i < paisesParse.size(); i++) {
            Pais nuevoPais = new Pais(paisesParse.get(i));
            paises.add(nuevoPais);
            paisesDic.put(paisesParse.get(i), nuevoPais);
        }
    }

    private void agregarAdyacencias() {
        for (int j = 0; j < paises.size(); j++) {
            int finalJ = j;
            this.adyacenciasParse.get(paises.get(j).obtenerNombre()).forEach(
                    pais -> paises.get(finalJ).agregarAdyacente(paisesDic.get(pais))
            );
        }
    }
}
