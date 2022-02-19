package com.example.muzeum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Api {
    static String BASE_URL = "http://localhost:8000/api/";

    public static List<Painting> getPaintings() throws Exception {
        JSONArray jsonArray =  genericGet("paintings");
        List<Painting> paintings = new ArrayList<>();

        for(Object o: jsonArray) {
            JSONObject ob = (JSONObject) o;

            int id = Integer.parseInt(ob.get("id").toString());
            String name = ob.get("title").toString();
            int year = Integer.parseInt(ob.get("year").toString());
            boolean display = (boolean) ob.get("on_display");

            paintings.add(new Painting(id, name, year, display));
        }

        return paintings;
    }

    public static List<Statue> getStatues() throws Exception {
        JSONArray jsonArray =  genericGet("statues");
        List<Statue> statues = new ArrayList<>();

        for(Object o: jsonArray) {
            JSONObject ob = (JSONObject) o;

            int id = Integer.parseInt(ob.get("id").toString());
            String person = ob.get("person").toString();
            int height = Integer.parseInt(ob.get("height").toString());
            int price = Integer.parseInt(ob.get("price").toString());

            statues.add(new Statue(id, person, height, price));
        }

        return statues;
    }

    private static JSONArray genericGet(String urlEnd) throws Exception {
        URL url = new URL(BASE_URL + urlEnd);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new Exception("Nem 200as responsecode");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = br.readLine();

        br.close();

        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(String.valueOf(line));
    }
}
