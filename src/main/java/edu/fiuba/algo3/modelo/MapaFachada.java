package edu.fiuba.algo3.modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class MapaFachada {
    private List<String> paisesParse;

    public MapaFachada() {
        LectorPaises lectorPaises = new LectorPaises();
        paisesParse = lectorPaises.obtenerPaises();
    }

    public List<Pais> inicializarMapa() {
        Dictionary<String, Pais> dicAux = new Hashtable<String, Pais>();
        List<Pais> paises = new ArrayList<Pais>();

        for (int i = 0; i < paisesParse.size(); i++) {
            Pais nuevoPais = new Pais(paisesParse.get(i));
            paises.add(nuevoPais);
            dicAux.put(paisesParse.get(i), nuevoPais);
        }

        return paises;
    }
}
