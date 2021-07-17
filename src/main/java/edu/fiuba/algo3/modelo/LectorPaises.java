package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorPaises {
    private JSONArray paisesList;
    public Dictionary<String, List<String>> adyacencias;
    public List<String> paises;

    public LectorPaises() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("fronteras.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray paisesList = (JSONArray) obj;
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
}
