package es.florida.cuaderno02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Ejercicio04 {
	
	static String enunciado = "04. Crear una modificación del programa número 2 para que lea el resultado que ha escrito el \r\n"
			+ "    programa 3 y lo muestre por pantalla. Deberá implementar algún procedimiento para \r\n"
			+ "    controlar que el fichero esté efectivamente escrito y su contenido disponible.\n";	
	
	
	/*
	 * Metodo lanzarSumador() 
	 * ACTION:	construye la llamada que vamos a pasar al processBuilder. Crea e inicia el 
	 * processBuilder. Pasa a la clase Ejercicio03 los parámetros con el intervalo y nombre 
	 * del fichero de salida.Comprueba que el fichero es accesible y controla las posibles excepciones.
 	 * INPUT: 	valores del intervalo a sumar (Integer) y nombre del fichero donde escribirá.
	 * OUTPUT: 	crea el fichero 
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

		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*Comprobación de que el fichero esté escrito o exista -> Mientras no pueda leer el fichero
		"ficheroLeido" continua en false y se repite el bucle. Una vez lo lee cambia a true, se sale
		y se sobreentiende que el fichero es accesible para su lectura. Se capturan los errores para 
		que no se interrumpa el bucle si no lo encuentra a la primera.*/
		boolean ficheroLeido = false;
		while (!ficheroLeido) {
			File fichero = new File(nombrefichero);
			FileReader fr;

			try {
				fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String resultado = br.readLine();
				System.out.print("Resultado de la lectura del fichero \"" + fichero + "\" es: " + resultado);
				ficheroLeido = true;
				br.close();
				fr.close();

			} catch (Exception e) {
				//No ponemos mensaje tan sólo deja seguir al bucle
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(enunciado);
		
		int n1 = 1;
		int n2 = 10;
		String nombrefichero = "resultado25.txt";
	
		lanzarSumador(n1, n2, nombrefichero);
	}

}

