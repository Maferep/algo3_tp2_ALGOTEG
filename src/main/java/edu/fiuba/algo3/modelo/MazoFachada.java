package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IMapa;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MazoFachada {
    LinkedList<Tarjeta> tarjetas;
    IMapa mapa;

    public MazoFachada(IMapa mapa) {
        this.mapa = mapa;
        this.tarjetas = new LinkedList<Tarjeta>();
        crearTarjetas();
    }

    private void crearTarjetas() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/cartas.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray tarjetas = (JSONArray) obj;

            parsearTarjetas(tarjetas);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsearTarjetas(JSONArray tarjetasJSON) {
        for (Object tarjetaJSON : tarjetasJSON) {
            JSONObject tarjetaJSONObject = (JSONObject) tarjetaJSON;
            IPais pais = mapa.obtenerPais((String) tarjetaJSONObject.get("Pais"));
            Simbolo simbolo = new Simbolo((String) tarjetaJSONObject.get("Simbolo"));

            Tarjeta tarjeta = new Tarjeta(pais, simbolo);
            tarjetas.add(tarjeta);
        }
    }

    public LinkedList<Tarjeta> obtenerTarjetas() {
        return tarjetas;
    }
}
