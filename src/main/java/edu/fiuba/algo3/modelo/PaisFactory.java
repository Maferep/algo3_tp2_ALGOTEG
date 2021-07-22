package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import java.util.*;

public class PaisFactory {
    private List<String> paisesParse;
    private Dictionary<String, List<String>> adyacenciasParse;
    private Dictionary<String, IPais> paisesDic;
    public List<IPais> paises;

    public PaisFactory() {
        LectorPaises lectorPaises = new LectorPaises();
        paisesParse = lectorPaises.obtenerPaises();
        adyacenciasParse = lectorPaises.obtenerAdyacencias();
        paisesDic = new Hashtable<String, IPais>();
        paises = new ArrayList<IPais>();

    }

    public List<IPais> inicializarMapa() {
        this.inicializarPaises();
        this.agregarAdyacencias();
        return paises;
    }

    @Deprecated
    //SUGERENCIA: Esto se comporta como una factory de paises que usa Mapa, 
    //deberiamos testear usando la lista 'paises' que devuelve
    public IPais obtenerPais(String pais) {
        return paisesDic.get(pais);
    }

    private void inicializarPaises() {
        for (int i = 0; i < paisesParse.size(); i++) {
            IPais nuevoPais = new Pais(paisesParse.get(i));
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
