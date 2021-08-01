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
    List<Continente> continentes;

    public MapaFachada() {
        paisesDict = new Hashtable<String, IPais>();
        continentes = new ArrayList<Continente>();
        crearPaises();
        crearContinentes();
    }

    private void crearPaises() {
        JSONParser jsonParser = new JSONParser();

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

    //TODO corregir advertencia!
    private void parsearPaises(JSONArray paises) {
        paises.forEach(pais ->
                paisesDict.put(
                (String) ((JSONObject) pais).get("Pais"),
                new Pais((String) ((JSONObject) pais).get("Pais"))
        ));
    }

    private void parsearAdyacencias(JSONArray paises) {
        for (int i = 0; i < paises.size(); i++) {
            List<String> adyacentes = new ArrayList<String>(
                    Arrays.asList
                            (((String) ((JSONObject) paises.get(i)).get("Limita con")).split(",")));

            int finalI = i;
            adyacentes.forEach(pais ->
                    paisesDict.get(
                    (String) ((JSONObject) paises.get(finalI)).get("Pais")).agregarAdyacente(
                            paisesDict.get(pais)));
        }
    }

    private void crearContinentes() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/continentes.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray continentesList = (JSONArray) obj;
            parsearContinentes(continentesList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsearContinentes(JSONArray continentesJSON) {
        for ( Object continenteJSON : continentesJSON ) {
            List<IPais> paises = new ArrayList<IPais>();

            continenteJSON = (JSONObject) continenteJSON;
            List<String> paisesContinente = (List<String>) ((JSONObject) continenteJSON).get("Contiene");

            for (String pais : paisesContinente) {
                paises.add(paisesDict.get(pais));
            }

            String nombreContinente = (String) ((JSONObject) continenteJSON).get("Continente");
            continentes.add(new Continente(nombreContinente, paises));
        }
    }

    public List<IPais> obtenerPaises(){
        return new ArrayList<IPais>(paisesDict.values());
    }

    public List<Continente> obtenerContinentes() {
        return continentes;
    }
}
