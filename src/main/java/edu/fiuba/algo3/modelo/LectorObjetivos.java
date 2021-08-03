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

public class LectorObjetivos {
    private List<Map<String, Integer>> listasDeContinentesYSusMinimos;

    public List<Map<String,Integer>> obtenerListasDeContinentesYSusMinimos() {
        return this.listasDeContinentesYSusMinimos;
    }

    public LectorObjetivos() {
        crearObjetivosContinentes();
    }

    private void crearObjetivosContinentes() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/objetivos.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray listaObjetivos = (JSONArray) obj;

            this.parsearObjetivo(listaObjetivos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsearObjetivo(JSONArray objetivos) {
        for(Object objetivo : objetivos) {
            //obtener lista de continentes del objetivo
            Object continentes =  ((JSONObject) objetivo).get("continentes");
            JSONArray arregloContinentes = (JSONArray) continentes;

            //obtener respectivos minimos
            Object minimos =  ((JSONObject) objetivo).get("minimos");
            JSONArray arregloMinimos = (JSONArray) minimos;

            //recorrer y guardar en un mapa los pares de continente y minimo
            int indice = 0;
            Map<String, Integer> continentesYMinimos = new HashMap<>();
            for(Object continente : arregloContinentes) {
                String nombreContinente = ((String) continente);
                Integer minimo =  (Integer) (arregloMinimos.get(indice));
                continentesYMinimos.put(nombreContinente, minimo);
                indice++;
            }
            listasDeContinentesYSusMinimos.add(continentesYMinimos);
        }
    } 
}
