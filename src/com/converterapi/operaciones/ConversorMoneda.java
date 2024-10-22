package com.converterapi.operaciones;

import com.converterapi.api.ApiCall;

import java.nio.DoubleBuffer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMoneda
{
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/8ee0160f7e3981137c9ce2df/pair/";

    public void realizaConversion (int opcion,Scanner teclado){
        String[] paresMoneda = obtenerParesMonedas(opcion);

        if(paresMoneda!=null){
            System.out.println("Ingrese el valor a convertir");
            String monedaCambio = validarNumero(teclado);

            String direccion = baseUrl + paresMoneda[0] +"/"+paresMoneda[1]+"/"+monedaCambio;
            ApiCall apiCall = new ApiCall();

            apiCall.fetchData(direccion, monedaCambio);
        }
    }

    private String[] obtenerParesMonedas(int opcion){
        switch (opcion){
            case 1: return  new String[]{"USD","ARS"};
            case 2: return  new String[]{"ARS","USD"};
            case 3: return  new String[]{"USD","BRL"};
            case 4: return  new String[]{"BRL","USD"};
            case 5: return  new String[]{"USD","COP"};
            case 6: return  new String[]{"COP","USD"};
            default:return null;

        }
    }

    private  String validarNumero(Scanner teclado){
        String monedaCambio = teclado.nextLine();
        boolean banderaIn = false;
        Double checkNum;

        while(!banderaIn){
            try{
                checkNum = Double.valueOf(monedaCambio);
                banderaIn = true;
            }catch(NumberFormatException e){
                System.out.println("Por favor ingrese  valores númericos y/o decimales:\n");
                monedaCambio = teclado.nextLine();
            }
        }
        return  monedaCambio;
    }

}
