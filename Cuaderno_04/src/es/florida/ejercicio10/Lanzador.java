/*10. Ejecuta el servidor y crea varias instancias cliente, cada una con diferentes parámetros. Para 
testear el funcionamiento puedes utilizar la clase lanzador que has creado anteriormente o 
la ejecución vía CMD de Windows.*/

package es.florida.ejercicio10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Lanzador {

	public static void main(String[] args) throws IOException {
		
		//Para que funcione he quitado todas las introducciones por teclado de Cliente 
		//porque con inherit() se queda pillado al introducir por consola
		
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classPath = System.getProperty("java.class.path");
		
		
		//Lanzamos servidor
		String className = "es.florida.ejercicio10.ServidorCalculo";
		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
		builder.inheritIO().start();
		
		//lanzamos cliente
		className = "es.florida.ejercicio10.ClienteCalculo";
		builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
		builder.inheritIO().start();
		
	}
}
