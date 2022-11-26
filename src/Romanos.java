package src;

import java.util.Scanner;
import classes.Cromanos;

public class Romanos {


    public static void main( String[] args ) {

        Scanner lectura = new Scanner( System.in );
        System.out.println( "Número romano:");
        String numeroRomano = lectura.next();
        String numeroArabigo = "";

        Cromanos convertidor = new Cromanos();
        numeroArabigo = convertidor.convierte( numeroRomano );
        
        System.out.println( numeroArabigo );

    } // ./main

} // ./Romanos class