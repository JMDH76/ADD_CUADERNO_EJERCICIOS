//Clase Lanzador del ejemplo
package es.florida.cuaderno02;

import java.io.File;
import java.util.ArrayList;

public class Ejercicio02 {
	
	static String enunciado = "02. Realiza un programa en Java que llame al programa anterior a través de una llamada de \r\n"
				+ "    sistema, es decir, creando un proceso nuevo con ProcessBuilder.\n";	

	/*
	 * Metodo lanzarSumador() 
	 * ACTION:	construye la llamada que vamos a pasar al processBuilder y la muestra por pantalla. Crea
	 * e inicia el processBuilder. Pasa a la clase Ejercicio01 los parámetros. Controla las posibles excepciones.
 	 * INPUT: 	valores del intervalo a sumar (Integer).
	 * OUTPUT: 	devuelve por pantalla el comando ("command") que pasa a processBuilder y su versión para en cmd de Windows.
	 */
	public static void lanzarSumador(Integer n1, Integer n2) {
			
		try {
			
			// Construccion de la llamada que vamos a pasar al ProcessBuilder "command"
			String clase = "es.florida.cuaderno02.Ejercicio01"; 		// Clase que vamos a llamar
			String javaHome = System.getProperty("java.home"); 			// Ubicacion del fichero java
			
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java"; 		// Ubicación del ejecutable
			String classpath = System.getProperty("java.class.path"); 	// Propieded de jdk para obtener el path de la clase
			String classname = clase; 									// Clase que vamos a instanciar
			
			ArrayList<String> command = new ArrayList<String>(); 		//Lista con los parámetros que usamos para crear command
			
			command.add(javaBin);		// C:\Users\josem\.p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_16.0.2.v20210721-1149\jre\bin\java
			command.add("-cp"); 		// Parámetro para llamar a una clase usando su "cp" = Class Path
			command.add(classpath);		// C:\Users\josem\eclipse-workspace\PSP\CUADERNO_EJERCICIOS\Cuaderno_02\bin
			command.add(classname);		// es.florida.cuaderno02.Ejercicio01
			
			// Parámetros que vamos a pasar a la clase que llamammos
			command.add(n1.toString());
			command.add(n2.toString());	
			
			//Salida de la instruccion "command" montada. 
			System.out.println("\nComando que se pasa a ProcessBuilder: " + command+"\n");
			System.out.println("Comando a ejecutar desde cmd.exe: " + command.toString().replace("," , "") + "\n"); //Sustituimos comas por espacios
			
			ProcessBuilder builder = new ProcessBuilder(command);	//Construimos el processBuilder

			Process process = builder.start();	// lanzamos processBuilder
			process.waitFor();  				// Este proceso esperará hasta que termine
			//System.out.println(process.exitValue());		//Comprobacion: si devuelve 0 es correcto

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public static void main(String[] args) {
		
		System.out.println(enunciado);
		
		int n1 = 1;
		int n2 = 10;
		lanzarSumador(n1,n2);		// parámetros para pasar a la clase que llamamos 
		System.out.println("Lanzado correctamente");
	}

}

