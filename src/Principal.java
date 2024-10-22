import com.converterapi.api.ApiCall;
import com.converterapi.modelos.Cambio;
import com.converterapi.modelos.ExchangeRate;

import com.converterapi.operaciones.ConversorMoneda;
import com.converterapi.operaciones.Operaciones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.jshell.Snippet;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.DoubleBuffer;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

      int opcion = 0;
      Scanner teclado = new Scanner(System.in);
        ConversorMoneda conversorMoneda = new ConversorMoneda();

        while(opcion!=7){
            Operaciones.mostrarMenu();
            opcion = Operaciones.leerOpcion(teclado);

            if(opcion!=7){
                conversorMoneda.realizaConversion(opcion,teclado);
            }
        }


    }
}
