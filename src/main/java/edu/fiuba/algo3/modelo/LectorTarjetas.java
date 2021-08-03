package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.modelo.excepciones.AlgoTegException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorTarjetas {

    private List<Tarjeta> tarjetas = new ArrayList<>();

    public LectorTarjetas(List<IPais> paises) throws Exception {
        crearTarjetas(paises);
    }
    private void crearTarjetas(List<IPais> paises) throws IOException, ParseException, AlgoTegException {
        JSONParser jsonParser = new JSONParser();

        FileReader reader 
            = new FileReader("src/main/resources/fronteras.json"); 

        JSONArray listaPaises = (JSONArray) jsonParser.parse(reader);
        for(Object unPais : listaPaises){
            if(!paises.contains(unPais)) {
                throw new AlgoTegException(null);
            }
            Object simbolo = ((JSONObject) unPais).get("Simbolo");
            IPais buscado = paises
                .stream()
                .filter(p -> 
                    p.obtenerNombre().equals(((JSONObject) unPais).get("Pais")))
                .findAny().get();
            tarjetas.add(new Tarjeta(buscado, new Simbolo((String)simbolo)));
        }
    }
}
