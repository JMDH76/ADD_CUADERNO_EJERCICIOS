package es.florida.cuaderno02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio03 {

	static String enunciado = "03. Crear una modificación del programa número 1 para que escriba el resultado \r\n"
			+ "    en un fichero en disco.\n";

	public static void main(String[] args) {

		//System.out.println(enunciado);
		Ejercicio03 sumador = new Ejercicio03();// Creamos un objeto de clase (en ejemplo "Sumador")
		int n1 = Integer.parseInt(args[0]); 	// Asignamos valores al intervalo a sumar desde args[]
		int n2 = Integer.parseInt(args[1]);
		int resultado = sumador.sumar(n1, n2); 	// Invocamos y pasamos a String para copiar en fichero
		escribirFichero(resultado);				//Escribimos en fichero
			
	}

	
	/*
	 * Metodo sumar() 
	 * FUNCIONAMIENTO: suma mediante un bucle todos los valores desde el valor 
	 * más pequeño del intervalo al mayor. 	 
 	 * INPUT: enteros con los valoresdel intervalo. 
	 * OUTPUT: entero con el valor de la suma
	 */
	public int sumar(int n1, int n2) {
		int suma = 0;
		for (int i = Math.min(n1, n2); i <= Math.max(n1, n2); i++) {
			suma = suma + i;
		}
		return suma;
	}
	
	
	/*
	 * METODO escribirFichero()
	 * FUNCIONAMIENTO: recibe el resultado de la suma, lo convierte a texto y 
	 * lo copia en el fichero de escritura.
	 * INPUT:	Integer con el valor de la suma.
	 * OUTPUT: 	crea el fichero y escribe el resultado, no devuelve nada*/
	public static void escribirFichero(Integer resultado) {

		FileWriter fw;
		try {
			
			String resultadotexto = String.valueOf(resultado);
			
			fw = new FileWriter("Fichero01.txt");		// Crea fichero
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write(resultadotexto); 					// Escribe resultado en fichero

			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
