package edu.fiuba.algo3.modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Dictionary;

public class MapaFachada {
    private List<String> paisesParse;


    public MapaFachada() {
        LectorPaises lectorPaises = new LectorPaises();
        paisesParse = lectorPaises.obtenerPaises();
    }

    public List<Pais> inicializarMapa() {
        Dictionary<String, Pais> dicAux;
        List<Pais> paises = new ArrayList<Pais>();

        for (int i = 0; i < paisesParse.size(); i++) {
            paises.add(new Pais(paisesParse.get(i)));
        }

        return paises;
    }
}
