# romabigo
Conversión de números romanos a números arábigos

# Uso
Entrada: String con el número romano.
Salida: String con el número arábigo.

# Ejemplo

Scanner lectura = new Scanner( System.in );
System.out.println( "Número romano:");
String numeroRomano = lectura.next();
String numeroArabigo = "";

Cromanos convertidor = new Cromanos();
numeroArabigo = convertidor.convierte( numeroRomano );

System.out.println( numeroArabigo );
