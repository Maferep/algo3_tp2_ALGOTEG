package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorPaises {
    public Dictionary<String, List<String>> adyacencias;
    public List<String> paises;

    public LectorPaises() {
        JSONParser jsonParser = new JSONParser();
        this.paises = new ArrayList<String>();
        this.adyacencias = new Hashtable<String, List <String>>();

        try (FileReader reader = new FileReader("src/main/resources/fronteras.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray paisesList = (JSONArray) obj;

            this.parsearPaises(paisesList);
            this.parsearAdyacencias(paisesList);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerPaises() {
       return this.paises;
    }

    public Dictionary<String, List<String>> obtenerAdyacencias() { return this.adyacencias; }

    private void parsearPaises(JSONArray paises) {
        paises.forEach(pais -> this.paises.add(
                (String) ((JSONObject) pais).get("Pais")
        ));
    }

    private void parsearAdyacencias(JSONArray paises) {
        for (int i = 0; i < paises.size(); i++) {
            this.adyacencias.put(
                    (String) ((JSONObject) paises.get(i)).get("Pais"),
                    new ArrayList<String>(
                            Arrays.asList(
                                    ((String) ((JSONObject) paises.get(i)).get("Limita con")).split(","))));
        }
    }
}
