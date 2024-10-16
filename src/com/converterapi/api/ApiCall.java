package com.converterapi.api;

import com.converterapi.modelos.Cambio;
import com.converterapi.modelos.ExchangeRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCall {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    //private String baseUrl = "https://v6.exchangerate-api.com/v6/8ee0160f7e3981137c9ce2df/pair/"; // +parametro1 +"/"+parametro2+"/"+ monedaCambio;

    //private String parametro1 ="";
    //private String parametro2 = "";
    private String monedaCambio = "1";

    public String fetchData(String URL, String monedaCambio) {
        String result = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            //System.out.println(json);

            ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);

            //System.out.println("Llegada: " + exchangeRate);

            Cambio cambio = new Cambio(exchangeRate);
            cambio.valorCambio = Double.valueOf(monedaCambio);

            result = cambio.toString();

            System.out.println(result);


        } catch (Exception e) {
            System.out.println("Ha ocurrido un error:" + e.getMessage());
        }
        return (result);
    }
}

