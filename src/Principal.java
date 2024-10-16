import com.converterapi.api.ApiCall;
import com.converterapi.modelos.Cambio;
import com.converterapi.modelos.ExchangeRate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        int opcion = 0;
        String baseUrl = "https://v6.exchangerate-api.com/v6/8ee0160f7e3981137c9ce2df/pair/"; // +parametro1 +"/"+parametro2+"/"+ monedaCambio;

         //System.out.println(baseUrl);

        System.out.println("\n***************************************************************");
        String menu = """
                Bienvenido, al Conversor de Monedas:
                 
                1 - Dólar =>> Peso Argentino
                2 - Peso Argentino ==> Dólar
                3 - Dólar =>> Real Brasileño
                4 - Real Brasileño =>> Dólar
                5 - Dólar =>> Peso Colombiano
                6 - Peso Colombiano =>> Dólar
                
                7 - Salir
                
                Elija una opcion válida:  
                """;
        Scanner teclado = new Scanner(System.in);

        while (opcion != 7){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Entrando a opcion 1");
                    System.out.println("Ingrese el valor que deseas convertir: ");
                    Double monedaCambio = (double) teclado.nextInt();
                    String parametro1="USD";
                    String parametro2="ARS";

                    String direccion = baseUrl + parametro1 +"/"+parametro2+"/"+ monedaCambio;
                    //System.out.println(direccion);
                    String valorMonedaStr = String.valueOf(monedaCambio);
                    ApiCall apiCall = new ApiCall();

                    apiCall.fetchData(direccion,valorMonedaStr);

            }
        }




    }
}
