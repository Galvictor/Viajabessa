package com.example.joaovictor.viajabessa.util;

import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by joaovictor on 11/05/2015.
 * Classe para abrir uma conexão com a api e pegar os resultados
 */
public class ApiGetRealJson {

    public JSONArray ApiGetRealJson() {

        // URL for getting all customers
        String api_url = "http://private-2fc58-viajabessa24.apiary-mock.com/pacotes";
        JSONArray jsonArray = null;

        try {
            URL url = new URL(api_url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;

            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            jsonArray = new JSONArray(responseStrBuilder.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }
}
