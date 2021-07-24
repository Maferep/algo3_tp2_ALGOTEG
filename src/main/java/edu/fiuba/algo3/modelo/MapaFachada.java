package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MapaFachada {
    Hashtable<String, IPais> paisesDict;
    Hashtable<String, Continente> continentesDict;

    public MapaFachada() {
        JSONParser jsonParser = new JSONParser();
        paisesDict = new Hashtable<String, IPais>();

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

    private void parsearPaises(JSONArray paises) {
        paises.forEach(pais -> paisesDict.put(
                (String) ((JSONObject) pais).get("Pais"),
                new Pais((String) ((JSONObject) pais).get("Pais"))
        ));
    }

    private void parsearAdyacencias(JSONArray paises) {

    }

    public List<IPais> obtenerPaises(){
        return new ArrayList<IPais>(paisesDict.values());
    }
}
