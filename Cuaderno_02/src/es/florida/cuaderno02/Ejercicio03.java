package es.florida.cuaderno02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio03 {

	static String enunciado = "03. Crear una modificación del programa número 1 para que escriba el resultado \r\n"
			+ "    en un fichero en disco.\n";
	

	public static void main(String[] args) {

		System.out.println(enunciado);
		
		//Pasamos los parámetros como argumentos
		int n1 = Integer.parseInt(args[0]); 		
		int n2 = Integer.parseInt(args[1]);
		int resultado = sumar(n1, n2); 				
		System.out.println("El resultado de la suma es: " + resultado);
		escribirFichero(resultado, args[2]);		
	}

	
	/*
	 * Metodo sumar() 
	 * ACTION: suma mediante un bucle todos los valores desde el valor 
	 * más pequeño del intervalo al mayor. 	 
 	 * INPUT: enteros con los valoresdel intervalo. 
	 * OUTPUT: entero con el valor de la suma
	 */
	public static int sumar(int n1, int n2) {
		int suma = 0;
		for (int i = Math.min(n1, n2); i <= Math.max(n1, n2); i++) {
			suma = suma + i;
		}
		return suma;
	}
	
	
	/*
	 * METODO escribirFichero()
	 * ACTION: recibe el resultado de la suma, lo convierte a texto y 
	 * lo copia en el fichero de escritura.
	 * INPUT:	Integer con el valor de la suma.
	 * OUTPUT: 	crea el fichero y escribe el resultado, no devuelve nada*/
	public static void escribirFichero(Integer resultado, String nombrefichero) {
		
		File fichero;
		FileWriter fw;
		BufferedWriter bw;
		try {
			System.out.println("Iniciando escritura en fichero... " + nombrefichero);
			String resultadotexto = String.valueOf(resultado); 
			fichero = new File (nombrefichero);
			fw = new FileWriter(fichero);				
			bw = new BufferedWriter(fw);
			fw.write(resultadotexto); 					
			fw.close();
			bw.close();
			
			System.out.println("Fichero \"" + nombrefichero + "\" escrito con exito");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
