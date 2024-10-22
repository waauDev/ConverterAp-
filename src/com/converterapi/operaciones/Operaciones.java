package com.converterapi.operaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {


    public static void mostrarMenu(){
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
        System.out.println(menu);
    }

    public static  int leerOpcion (Scanner teclado){
        int opcion =0;
        boolean bandera= false;

        while (!bandera){
            try{
            opcion = teclado.nextInt();
            bandera = true;
            }catch (InputMismatchException e){
                System.out.println("Digite por favor un numero de acuerdo al menu");
                teclado.next();
            }

        }
        teclado.nextLine();
        return  opcion;

    }
}
