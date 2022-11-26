package classes;

import java.util.Map;
import java.util.HashMap;

public class Cromanos {

   private String[] millaresRomanos = new String [] { "MMM", "MM", "M" };
   private int[]    millaresArabigos = new int[] {3, 2, 1};

   private String[] centenas = new String [] { "DCCC", "DCC", "CCC", "CM", "DC", "CD", "CC", "D", "C" };
   private int[] valores_centenas = new int[] {8, 7, 3, 9, 6, 4, 2, 5, 1 };   

   private String[] decenas  = new String [] { "LCCC", "LCC", "XXX", "XC", "LC", "XL", "XX", "L", "X" };
   private int[] valores_decenas = new int[] {8, 7, 3, 9, 6, 4, 2, 5, 1 };   

   private String[] unidades  = new String [] { "VIII", "VII", "III", "IX", "VI", "IV", "II", "V", "I" };
   private int[] valores_unidades = new int[] {8, 7, 3, 9, 6, 4, 2, 5, 1 };   
   
    public String convierte( String numeroRomano )  {
        
        
        int numeroArabigo = 0; // Valor de salida
        int posicionBuscar; // Temporal para realizar las búsquedas

        if( numeroRomano == null || numeroRomano.isEmpty() ) {
            return "ERROR EN EL NUMERO DE ENTRADA";
        }
        
        posicionBuscar = buscarElementoGrupo( numeroRomano, millaresRomanos );        
        if( posicionBuscar != -1) {
            numeroArabigo += millaresArabigos[ posicionBuscar ] * 1000;
            numeroRomano   = numeroRomano.substring( millaresRomanos[ posicionBuscar ].length() );
        } // ./if

        posicionBuscar = buscarElementoGrupo( numeroRomano, centenas );        
        if( posicionBuscar != -1) {            
            numeroArabigo += valores_centenas[ posicionBuscar ] * 100;            
            numeroRomano   = numeroRomano.substring( centenas[ posicionBuscar ].length() );
        } // ./if

        posicionBuscar = buscarElementoGrupo( numeroRomano, decenas );

        if( posicionBuscar != -1 ) {
            numeroArabigo += valores_decenas[ posicionBuscar ] * 10;
            numeroRomano   = numeroRomano.substring( decenas[ posicionBuscar ].length() );
        } // ./if               

        posicionBuscar = buscarElementoGrupo( numeroRomano, unidades );

        if( posicionBuscar != -1 ) {
            numeroArabigo += valores_unidades[ posicionBuscar ];
            numeroRomano   = numeroRomano.substring ( unidades[ posicionBuscar ].length() );
        } // ./if     
                
         
        if( !numeroRomano.isEmpty() ) {  
            return "ERROR EN EL NUMERO DE ENTRADA";
        }

        return String.valueOf(numeroArabigo);
    } // ./convierte

    private int buscarElementoGrupo( String numeroEntrada, String [] arregloRomano  ) {

        String numeroRomanoArreglo;
        int busqueda, n = arregloRomano.length, longNumeroRomanoArreglo, longNumeroEntrada;
        
        for( int i = 0; i < n; i ++ ) {
            numeroRomanoArreglo = arregloRomano[i];
            
            longNumeroRomanoArreglo = numeroRomanoArreglo.length();
            longNumeroEntrada       = numeroEntrada.length();

            if( longNumeroRomanoArreglo <= longNumeroEntrada ) {
                busqueda = numeroEntrada.indexOf( numeroRomanoArreglo );
                
                if( busqueda == 0 ) {
                    return i;
                } // ./ fin if(busqueda)
            }

        }        

        return -1;

    } // ./ buscarElementoGrupo
}