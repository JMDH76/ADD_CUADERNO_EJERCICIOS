/*6. Como habrás podido observar, cada uno de los programas anteriores se ejecuta de forma 
independiente (cada uno tiene su main). Una forma de ver la ejecución en Eclipse es 
creándote un tercer programa que funcione como lanzador, tal como hiciste en el tema 
sobre Multiproceso. Implementa ahora un programa lanzador que ejecute el servidor y el 
cliente y que muestre todas las salidas por consola.*/

package es.florida.ejercicio06;

import java.io.File;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) throws IOException {
		
		//Para que funcione he quitado todas las introducciones por teclado de Cliente 
		//porque con inherit() se queda pillado al introducir por consola
		
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classPath = System.getProperty("java.class.path");
		
		//Lanzamos servidor
		String className = "es.florida.ejercicio06.Servidor";
		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
		builder.inheritIO().start();
		
		//Lanzamos Cliente
		className = "es.florida.ejercicio06.Cliente";
		builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
		builder.inheritIO().start();
		
	}
}
