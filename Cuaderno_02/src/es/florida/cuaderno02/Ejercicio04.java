package es.florida.cuaderno02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio04 {
	
	static String enunciado = "04. Crear una modificaci�n del programa n�mero 2 para que lea el resultado que ha escrito el \r\n"
			+ "programa 3 y lo muestre por pantalla. Deber� implementar alg�n procedimiento para \r\n"
			+ "controlar que el fichero est� efectivamente escrito y su contenido disponible.\n";	
	
	
	static final int NUM_PROCESOS = 4;
	static final String PREFIJO_FICHEROS = "fichero";
	static final int NUM_INICIO = 1;
	static final int NUM_FIN = 100;
	
	
	public static void lanzarSumador(Integer n1, Integer n2, String fichResultados) {

		String clase = "es.florida.cuaderno02.Sumador_EJ04";
		File directorioSumador;
		directorioSumador = new File("C:\\Users\\josem\\eclipse-workspace\\PSP\\CUADERNO_EJERCICIOS\\Cuaderno_02");
		
		File fichResultado = new File(fichResultados);
		
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String classname = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(classname);
			command.add(String.valueOf(n1));
			command.add(String.valueOf(n2));

			ProcessBuilder builder = new ProcessBuilder(command); // Construimos el processBuilder
			builder.directory(directorioSumador); // Donde se van a guardar los ficheros que vamos a generar
			builder.redirectOutput(fichResultado); // Nos permite escribir la salida en fichResultado

			Process p = builder.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static int getResultadoFichero(String nombreFichero) {

		int suma = 0;
		try {
			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);
			String linea = br.readLine();
			suma = Integer.parseInt(linea);
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir " + nombreFichero);

		} catch (IOException e) {

			System.out.println(nombreFichero + " est� vac�o.");
		}
		return suma;
	}
	
	
	
	public static int getSumaTotal(int numFicheros) {
		int sumaTotal = 0;
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i));
		}

		return sumaTotal;
	}
	
	public static void main(String[] args) {

		int n1 = NUM_INICIO;
		int n2 = NUM_FIN;
		int salto = (n2 / NUM_PROCESOS) - 1;

		for (int i = 1; i <= NUM_PROCESOS; i++) {
			System.out.println("n1: " + n1);
			int resultadoSumaConSalto = n1 + salto;
			System.out.println("n2: " + resultadoSumaConSalto);
			lanzarSumador(n1, resultadoSumaConSalto, PREFIJO_FICHEROS + String.valueOf(i));
			n1 = n1 + salto + 1;
			System.out.println("Suma lanzada...");
		}

		boolean comprobarfin = false;
		int sumaTotal = 0;

		while (!comprobarfin) {
			try {
				sumaTotal = getSumaTotal(NUM_PROCESOS);
				comprobarfin = true;
			} catch (Exception e) {
				// nada
			}
		}
		System.out.println("La suma total es: " + sumaTotal);
	}

}