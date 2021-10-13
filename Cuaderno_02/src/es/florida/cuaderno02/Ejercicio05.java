package es.florida.cuaderno02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Ejercicio05 {
	
	static String enunciado = "04. Crear una modificación del programa número 2 para que lea el resultado que ha escrito el \r\n"
			+ "    programa 3 y lo muestre por pantalla. Deberá implementar algún procedimiento para \r\n"
			+ "    controlar que el fichero esté efectivamente escrito y su contenido disponible.\n";	
	
	static final int NUM_PROCESOS = 2;
	static final String PREFIJO_FICHEROS = "fichero";
	static final int NUM_INICIO = 10;
	static final int NUM_FIN = 100;

	
	/*
	 * Metodo lanzarSumador() 
	 * ACTION:	construye la llamada que vamos a pasar al processBuilder. Crea e inicia el 
	 * processBuilder. Pasa a la clase Ejercicio03 los parámetros con el intervalo y nombre 
	 * del fichero de salida. Comprueba que el fichero es accesible y controla las posibles 
	 * excepciones.
 	 * INPUT: 	valores del intervalo a sumar (Integer) y nombre del fichero donde escribirá.
	 * OUTPUT: 	contenido del fichero que ha leido por consola.
	 */
	public static void lanzarSumador(Integer n1, Integer n2, String nombrefichero) {
		
		String clase = "es.florida.cuaderno02.Ejercicio03";
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String classname = clase;
		ArrayList<String> command = new ArrayList<String>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(classname);
		command.add(n1.toString());
		command.add(n2.toString());
		command.add(nombrefichero);

		//System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace("," , "") + "\n");
		ProcessBuilder builder = new ProcessBuilder(command);

		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean ficheroLeido = false;
		while (!ficheroLeido) {
			File fichero = new File(nombrefichero);
			FileReader fr;

			try {
				fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String resultado = br.readLine();
				System.out.println("Resultado de la lectura del fichero \"" + fichero + "\" es: " + resultado);
				ficheroLeido = true;
				br.close();
				fr.close();

			} catch (Exception e) {
			
			}
		}
	}
	
	
	public static void main(String[] args) {

		System.out.println(enunciado);

		int n1 = NUM_INICIO;
		int n2 = NUM_FIN;
		
		//divide el intervalo según los procesos que se piden
		int salto = (((n2 - n1) / NUM_PROCESOS));	

		// Bucle para repetir la llamada según el numero de procesos que se soliciten.
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			System.out.println("n1 = " + n1);

			/* Condición para dar valor a n2 cuando n1 != 1; si no, 
			los intervalos no son correctos*/
			if (i == 1) n2 = n1 + salto;
			else n2 = n1 + salto - 1;

			System.out.println("n2 = " + n2);
			String nombrefichero = PREFIJO_FICHEROS + "_" + i + ".txt";
			lanzarSumador(n1, n2, nombrefichero);
			n1 = n1 + salto + 1;
		}
	}

}

